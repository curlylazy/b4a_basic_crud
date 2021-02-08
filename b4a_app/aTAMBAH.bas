B4A=true
Group=Default Group
ModulesStructureVersion=1
Type=Activity
Version=10.5
@EndOfDesignText@
#Region  Activity Attributes 
	#FullScreen: False
	#IncludeTitle: True
#End Region

Sub Process_Globals
	
End Sub

Sub Globals
	' jika ada error, silahkan pilih tab "Library" di pojok kanan bawah
	' kemudian cari lib yg namanya "ViewsEx Views" pilih centang.
	Private txtKodeitem As FloatLabeledEditText
	Private txtNamaitem As FloatLabeledEditText
	Private txtHargaitem As FloatLabeledEditText
	Private btnKembali As Button
	Private btnSimpan As Button
End Sub

Sub Activity_Create(FirstTime As Boolean)
	Activity.LoadLayout("vTAMBAH")
	Activity.Title = "Tambah Data"
	
	txtKodeitem.Hint = "Kodeitem"
	txtKodeitem.SetLayout(10dip, 10dip, 95%x, 55dip)
	
	txtNamaitem.Hint = "Namaitem"
	txtNamaitem.SetLayout(10dip, txtKodeitem.Top + txtKodeitem.Height, 95%x, 55dip)
	
	txtHargaitem.Hint = "Hargaitem"
	txtHargaitem.EditText.InputType = txtHargaitem.EditText.INPUT_TYPE_NUMBERS
	txtHargaitem.SetLayout(10dip, txtNamaitem.Top + txtNamaitem.Height, 95%x, 55dip)
	
	btnKembali.Text = "Kembali"
	btnKembali.SetLayout(10dip, txtHargaitem.Top + txtHargaitem.Height, 35%x, 55dip)
	
	btnSimpan.Text = "Simpan"
	btnSimpan.SetLayout(btnKembali.Left + btnKembali.Width, txtHargaitem.Top + txtHargaitem.Height, 35%x, 55dip)
End Sub

Sub Activity_Resume

End Sub

Sub Activity_Pause (UserClosed As Boolean)

End Sub


' method ini digenerate dari designer, pilih componennya, kemudia akan ada sub "Click" centrang dan generate lagi
Private Sub btnSimpan_Click
	Msgbox2Async("Simpan data sekarang.", "KONFIRMASI", "Ya", "Tidak", "", Null, True)
	Wait For Msgbox_Result(Result As Int)
	If Result = DialogResponse.POSITIVE Then
		
		Try
			ProgressDialogShow("Proses..")
			Dim NV As Map
			Dim j As HttpJob
	
			j.Initialize("", Me)
			NV.Initialize
			NV.Put("kodeitem", txtKodeitem.Text)
			NV.Put("namaitem", txtNamaitem.Text)
			NV.Put("hargaitem", txtHargaitem.Text)
			j.PostMultipart("http://192.168.102.50/b4a_ws/insert.php", NV, Null)
			Wait For (j) JobDone(j As HttpJob)
			If j.Success Then
		
				ProgressDialogHide
				Log(j.GetString)
				
				If j.GetString == "sukses" Then
					txtKodeitem.Text = ""
					txtNamaitem.Text = ""
					txtHargaitem.Text = ""
					ToastMessageShow("Berhasil tambah data..", True)
				Else
					ToastMessageShow(j.GetString, True)
				End If
				
			End If
			j.Release
		Catch
			ToastMessageShow(LastException, True)
			Log(LastException)
		End Try
		
	End If
End Sub

Private Sub btnKembali_Click
	StartActivity(aLIST)
End Sub