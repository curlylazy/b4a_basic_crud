B4A=true
Group=Default Group
ModulesStructureVersion=1
Type=Activity
Version=10.2
@EndOfDesignText@
#Region  Activity Attributes 
	#FullScreen: False
	#IncludeTitle: True
#End Region

Sub Process_Globals
	
End Sub

Sub Globals
	
	' ini diambil dari "Designer", pilih dulu komponentnya, klik kanan, kemudian pilih generate
	' method event berupa textchange maupun click button juga bisa digenerate dari "Designer"
	Private btnTambah As Button
	Private btnCari As Button
	Private ListView1 As ListView
End Sub

Sub Activity_Create(FirstTime As Boolean)
	' Pilih layout yang ingin diload, layout juga dibuat melalui "Designer"
	Activity.LoadLayout("vLIST")
	
	btnTambah.Text = "Tambah Data"
	btnTambah.SetLayout(10dip, 10dip, 35%x, 55dip)
	
	btnCari.Text = "Cari"
	btnCari.SetLayout(btnTambah.Left + btnTambah.Width + 10dip, 10dip, 35%x, 55dip)
	
	ListView1.SetLayout(10dip, btnTambah.Height + btnTambah.Height + 5dip, 95%x, 250dip)
	ListView1.TwoLinesLayout.ItemHeight = 85dip
	ListView1.TwoLinesLayout.Label.Top = 5dip
	ListView1.TwoLinesLayout.Label.TextColor = Colors.DarkGray
	ListView1.TwoLinesLayout.Label.Height = 25dip
	ListView1.TwoLinesLayout.SecondLabel.Height = 50dip
	
	ProgressDialogShow("Loading..")
	Wait For(tampillistdata) Complete (Result As Int)
	ProgressDialogHide
	
End Sub

Sub Activity_Resume

End Sub

Sub Activity_Pause (UserClosed As Boolean)

End Sub

Sub tampillistdata As ResumableSub
	
	Try
		ProgressDialogShow("Proses..")
		Dim NV As Map
		Dim j As HttpJob
	
		j.Initialize("", Me)
		NV.Initialize
		NV.Put("katakunci", "")
		j.PostMultipart("http://192.168.102.50/b4a_ws/select.php", NV, Null)
		Wait For (j) JobDone(j As HttpJob)
		If j.Success Then
		
			ProgressDialogHide
		
			Log(j.GetString)
			If j.GetString = Null Or j.GetString = "[]" Then
				ToastMessageShow("Tidak ada data yang ditampilkan", False)
				Return 0
			End If
		
			Dim jp As JSONParser
			jp.Initialize(j.GetString)
			Dim rows As List = jp.NextArray
			
			ListView1.Clear
			
			For Each row As Map In rows
			
				ListView1.AddTwoLines(row.Get("kodeitem"), row.Get("namaitem"))
				
			Next
		
		End If
		j.Release
	
		Log("Selesai Load")
	
		
	Catch
		ProgressDialogHide
		ToastMessageShow(LastException, True)
		Log(LastException)
	End Try
	
	Return 0
	
End Sub

' digenerate dari "Designer"
Private Sub ListView1_ItemClick (Position As Int, Value As Object)
	aEDIT.kodeitem = Value
	StartActivity(aEDIT)
	Activity.Finish
End Sub

Private Sub btnCari_Click
	ProgressDialogShow("Loading..")
	Wait For(tampillistdata) Complete (Result As Int)
	ProgressDialogHide
End Sub

Private Sub btnTambah_Click
	StartActivity(aTAMBAH)
	Activity.Finish
End Sub