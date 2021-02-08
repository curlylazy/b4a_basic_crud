package b4a.example;

import anywheresoftware.b4a.BA;
import anywheresoftware.b4a.pc.*;

public class atambah_subs_0 {


public static RemoteObject  _activity_create(RemoteObject _firsttime) throws Exception{
try {
		Debug.PushSubsStack("Activity_Create (atambah) ","atambah",3,atambah.mostCurrent.activityBA,atambah.mostCurrent,20);
if (RapidSub.canDelegate("activity_create")) { return b4a.example.atambah.remoteMe.runUserSub(false, "atambah","activity_create", _firsttime);}
Debug.locals.put("FirstTime", _firsttime);
 BA.debugLineNum = 20;BA.debugLine="Sub Activity_Create(FirstTime As Boolean)";
Debug.ShouldStop(524288);
 BA.debugLineNum = 21;BA.debugLine="Activity.LoadLayout(\"vTAMBAH\")";
Debug.ShouldStop(1048576);
atambah.mostCurrent._activity.runMethodAndSync(false,"LoadLayout",(Object)(RemoteObject.createImmutable("vTAMBAH")),atambah.mostCurrent.activityBA);
 BA.debugLineNum = 22;BA.debugLine="Activity.Title = \"Tambah Data\"";
Debug.ShouldStop(2097152);
atambah.mostCurrent._activity.runMethod(false,"setTitle",BA.ObjectToCharSequence("Tambah Data"));
 BA.debugLineNum = 24;BA.debugLine="txtKodeitem.Hint = \"Kodeitem\"";
Debug.ShouldStop(8388608);
atambah.mostCurrent._txtkodeitem.runMethod(true,"setHint",BA.ObjectToString("Kodeitem"));
 BA.debugLineNum = 25;BA.debugLine="txtKodeitem.SetLayout(10dip, 10dip, 95%x, 55dip)";
Debug.ShouldStop(16777216);
atambah.mostCurrent._txtkodeitem.runVoidMethod ("SetLayout",(Object)(atambah.mostCurrent.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, 10)))),(Object)(atambah.mostCurrent.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, 10)))),(Object)(atambah.mostCurrent.__c.runMethod(true,"PerXToCurrent",(Object)(BA.numberCast(float.class, 95)),atambah.mostCurrent.activityBA)),(Object)(atambah.mostCurrent.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, 55)))));
 BA.debugLineNum = 27;BA.debugLine="txtNamaitem.Hint = \"Namaitem\"";
Debug.ShouldStop(67108864);
atambah.mostCurrent._txtnamaitem.runMethod(true,"setHint",BA.ObjectToString("Namaitem"));
 BA.debugLineNum = 28;BA.debugLine="txtNamaitem.SetLayout(10dip, txtKodeitem.Top + tx";
Debug.ShouldStop(134217728);
atambah.mostCurrent._txtnamaitem.runVoidMethod ("SetLayout",(Object)(atambah.mostCurrent.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, 10)))),(Object)(RemoteObject.solve(new RemoteObject[] {atambah.mostCurrent._txtkodeitem.runMethod(true,"getTop"),atambah.mostCurrent._txtkodeitem.runMethod(true,"getHeight")}, "+",1, 1)),(Object)(atambah.mostCurrent.__c.runMethod(true,"PerXToCurrent",(Object)(BA.numberCast(float.class, 95)),atambah.mostCurrent.activityBA)),(Object)(atambah.mostCurrent.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, 55)))));
 BA.debugLineNum = 30;BA.debugLine="txtHargaitem.Hint = \"Hargaitem\"";
Debug.ShouldStop(536870912);
atambah.mostCurrent._txthargaitem.runMethod(true,"setHint",BA.ObjectToString("Hargaitem"));
 BA.debugLineNum = 31;BA.debugLine="txtHargaitem.EditText.InputType = txtHargaitem.Ed";
Debug.ShouldStop(1073741824);
atambah.mostCurrent._txthargaitem.runMethod(false,"getEditText").runMethod(true,"setInputType",atambah.mostCurrent._txthargaitem.runMethod(false,"getEditText").getField(true,"INPUT_TYPE_NUMBERS"));
 BA.debugLineNum = 32;BA.debugLine="txtHargaitem.SetLayout(10dip, txtNamaitem.Top + t";
Debug.ShouldStop(-2147483648);
atambah.mostCurrent._txthargaitem.runVoidMethod ("SetLayout",(Object)(atambah.mostCurrent.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, 10)))),(Object)(RemoteObject.solve(new RemoteObject[] {atambah.mostCurrent._txtnamaitem.runMethod(true,"getTop"),atambah.mostCurrent._txtnamaitem.runMethod(true,"getHeight")}, "+",1, 1)),(Object)(atambah.mostCurrent.__c.runMethod(true,"PerXToCurrent",(Object)(BA.numberCast(float.class, 95)),atambah.mostCurrent.activityBA)),(Object)(atambah.mostCurrent.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, 55)))));
 BA.debugLineNum = 34;BA.debugLine="btnKembali.Text = \"Kembali\"";
Debug.ShouldStop(2);
atambah.mostCurrent._btnkembali.runMethod(true,"setText",BA.ObjectToCharSequence("Kembali"));
 BA.debugLineNum = 35;BA.debugLine="btnKembali.SetLayout(10dip, txtHargaitem.Top + tx";
Debug.ShouldStop(4);
atambah.mostCurrent._btnkembali.runVoidMethod ("SetLayout",(Object)(atambah.mostCurrent.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, 10)))),(Object)(RemoteObject.solve(new RemoteObject[] {atambah.mostCurrent._txthargaitem.runMethod(true,"getTop"),atambah.mostCurrent._txthargaitem.runMethod(true,"getHeight")}, "+",1, 1)),(Object)(atambah.mostCurrent.__c.runMethod(true,"PerXToCurrent",(Object)(BA.numberCast(float.class, 35)),atambah.mostCurrent.activityBA)),(Object)(atambah.mostCurrent.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, 55)))));
 BA.debugLineNum = 37;BA.debugLine="btnSimpan.Text = \"Simpan\"";
Debug.ShouldStop(16);
atambah.mostCurrent._btnsimpan.runMethod(true,"setText",BA.ObjectToCharSequence("Simpan"));
 BA.debugLineNum = 38;BA.debugLine="btnSimpan.SetLayout(btnKembali.Left + btnKembali.";
Debug.ShouldStop(32);
atambah.mostCurrent._btnsimpan.runVoidMethod ("SetLayout",(Object)(RemoteObject.solve(new RemoteObject[] {atambah.mostCurrent._btnkembali.runMethod(true,"getLeft"),atambah.mostCurrent._btnkembali.runMethod(true,"getWidth")}, "+",1, 1)),(Object)(RemoteObject.solve(new RemoteObject[] {atambah.mostCurrent._txthargaitem.runMethod(true,"getTop"),atambah.mostCurrent._txthargaitem.runMethod(true,"getHeight")}, "+",1, 1)),(Object)(atambah.mostCurrent.__c.runMethod(true,"PerXToCurrent",(Object)(BA.numberCast(float.class, 35)),atambah.mostCurrent.activityBA)),(Object)(atambah.mostCurrent.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, 55)))));
 BA.debugLineNum = 39;BA.debugLine="End Sub";
Debug.ShouldStop(64);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _activity_pause(RemoteObject _userclosed) throws Exception{
try {
		Debug.PushSubsStack("Activity_Pause (atambah) ","atambah",3,atambah.mostCurrent.activityBA,atambah.mostCurrent,45);
if (RapidSub.canDelegate("activity_pause")) { return b4a.example.atambah.remoteMe.runUserSub(false, "atambah","activity_pause", _userclosed);}
Debug.locals.put("UserClosed", _userclosed);
 BA.debugLineNum = 45;BA.debugLine="Sub Activity_Pause (UserClosed As Boolean)";
Debug.ShouldStop(4096);
 BA.debugLineNum = 47;BA.debugLine="End Sub";
Debug.ShouldStop(16384);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _activity_resume() throws Exception{
try {
		Debug.PushSubsStack("Activity_Resume (atambah) ","atambah",3,atambah.mostCurrent.activityBA,atambah.mostCurrent,41);
if (RapidSub.canDelegate("activity_resume")) { return b4a.example.atambah.remoteMe.runUserSub(false, "atambah","activity_resume");}
 BA.debugLineNum = 41;BA.debugLine="Sub Activity_Resume";
Debug.ShouldStop(256);
 BA.debugLineNum = 43;BA.debugLine="End Sub";
Debug.ShouldStop(1024);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _btnkembali_click() throws Exception{
try {
		Debug.PushSubsStack("btnKembali_Click (atambah) ","atambah",3,atambah.mostCurrent.activityBA,atambah.mostCurrent,92);
if (RapidSub.canDelegate("btnkembali_click")) { return b4a.example.atambah.remoteMe.runUserSub(false, "atambah","btnkembali_click");}
 BA.debugLineNum = 92;BA.debugLine="Private Sub btnKembali_Click";
Debug.ShouldStop(134217728);
 BA.debugLineNum = 93;BA.debugLine="StartActivity(aLIST)";
Debug.ShouldStop(268435456);
atambah.mostCurrent.__c.runVoidMethod ("StartActivity",atambah.processBA,(Object)((atambah.mostCurrent._alist.getObject())));
 BA.debugLineNum = 94;BA.debugLine="End Sub";
Debug.ShouldStop(536870912);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static void  _btnsimpan_click() throws Exception{
try {
		Debug.PushSubsStack("btnSimpan_Click (atambah) ","atambah",3,atambah.mostCurrent.activityBA,atambah.mostCurrent,51);
if (RapidSub.canDelegate("btnsimpan_click")) { b4a.example.atambah.remoteMe.runUserSub(false, "atambah","btnsimpan_click"); return;}
ResumableSub_btnSimpan_Click rsub = new ResumableSub_btnSimpan_Click(null);
rsub.resume(null, null);
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static class ResumableSub_btnSimpan_Click extends BA.ResumableSub {
public ResumableSub_btnSimpan_Click(b4a.example.atambah parent) {
this.parent = parent;
}
java.util.LinkedHashMap<String, Object> rsLocals = new java.util.LinkedHashMap<String, Object>();
b4a.example.atambah parent;
RemoteObject _result = RemoteObject.createImmutable(0);
RemoteObject _nv = RemoteObject.declareNull("anywheresoftware.b4a.objects.collections.Map");
RemoteObject _j = RemoteObject.declareNull("b4a.example.httpjob");

@Override
public void resume(BA ba, RemoteObject result) throws Exception{
try {
		Debug.PushSubsStack("btnSimpan_Click (atambah) ","atambah",3,atambah.mostCurrent.activityBA,atambah.mostCurrent,51);
Debug.locals = rsLocals;Debug.currentSubFrame.locals = rsLocals;

    while (true) {
try {

        switch (state) {
            case -1:
return;

case 0:
//C
this.state = 1;
 BA.debugLineNum = 52;BA.debugLine="Msgbox2Async(\"Simpan data sekarang.\", \"KONFIRMASI";
Debug.ShouldStop(524288);
parent.mostCurrent.__c.runVoidMethod ("Msgbox2Async",(Object)(BA.ObjectToCharSequence("Simpan data sekarang.")),(Object)(BA.ObjectToCharSequence("KONFIRMASI")),(Object)(BA.ObjectToString("Ya")),(Object)(BA.ObjectToString("Tidak")),(Object)(BA.ObjectToString("")),RemoteObject.declareNull("anywheresoftware.b4a.AbsObjectWrapper").runMethod(false, "ConvertToWrapper", RemoteObject.createNew("anywheresoftware.b4a.objects.drawable.CanvasWrapper.BitmapWrapper"), parent.mostCurrent.__c.getField(false,"Null")),atambah.processBA,(Object)(parent.mostCurrent.__c.getField(true,"True")));
 BA.debugLineNum = 53;BA.debugLine="Wait For Msgbox_Result(Result As Int)";
Debug.ShouldStop(1048576);
parent.mostCurrent.__c.runVoidMethod ("WaitFor","msgbox_result", atambah.processBA, anywheresoftware.b4a.pc.PCResumableSub.createDebugResumeSub(this, "atambah", "btnsimpan_click"), null);
this.state = 21;
return;
case 21:
//C
this.state = 1;
_result = (RemoteObject) result.getArrayElement(true,RemoteObject.createImmutable(0));Debug.locals.put("Result", _result);
;
 BA.debugLineNum = 54;BA.debugLine="If Result = DialogResponse.POSITIVE Then";
Debug.ShouldStop(2097152);
if (true) break;

case 1:
//if
this.state = 20;
if (RemoteObject.solveBoolean("=",_result,BA.numberCast(double.class, parent.mostCurrent.__c.getField(false,"DialogResponse").getField(true,"POSITIVE")))) { 
this.state = 3;
}if (true) break;

case 3:
//C
this.state = 4;
 BA.debugLineNum = 56;BA.debugLine="Try";
Debug.ShouldStop(8388608);
if (true) break;

case 4:
//try
this.state = 19;
this.catchState = 18;
this.state = 6;
if (true) break;

case 6:
//C
this.state = 7;
this.catchState = 18;
 BA.debugLineNum = 57;BA.debugLine="ProgressDialogShow(\"Proses..\")";
Debug.ShouldStop(16777216);
parent.mostCurrent.__c.runVoidMethod ("ProgressDialogShow",atambah.mostCurrent.activityBA,(Object)(BA.ObjectToCharSequence(RemoteObject.createImmutable("Proses.."))));
 BA.debugLineNum = 58;BA.debugLine="Dim NV As Map";
Debug.ShouldStop(33554432);
_nv = RemoteObject.createNew ("anywheresoftware.b4a.objects.collections.Map");Debug.locals.put("NV", _nv);
 BA.debugLineNum = 59;BA.debugLine="Dim j As HttpJob";
Debug.ShouldStop(67108864);
_j = RemoteObject.createNew ("b4a.example.httpjob");Debug.locals.put("j", _j);
 BA.debugLineNum = 61;BA.debugLine="j.Initialize(\"\", Me)";
Debug.ShouldStop(268435456);
_j.runClassMethod (b4a.example.httpjob.class, "_initialize" /*RemoteObject*/ ,atambah.processBA,(Object)(BA.ObjectToString("")),(Object)(atambah.getObject()));
 BA.debugLineNum = 62;BA.debugLine="NV.Initialize";
Debug.ShouldStop(536870912);
_nv.runVoidMethod ("Initialize");
 BA.debugLineNum = 63;BA.debugLine="NV.Put(\"kodeitem\", txtKodeitem.Text)";
Debug.ShouldStop(1073741824);
_nv.runVoidMethod ("Put",(Object)(RemoteObject.createImmutable(("kodeitem"))),(Object)((parent.mostCurrent._txtkodeitem.runMethod(true,"getText"))));
 BA.debugLineNum = 64;BA.debugLine="NV.Put(\"namaitem\", txtNamaitem.Text)";
Debug.ShouldStop(-2147483648);
_nv.runVoidMethod ("Put",(Object)(RemoteObject.createImmutable(("namaitem"))),(Object)((parent.mostCurrent._txtnamaitem.runMethod(true,"getText"))));
 BA.debugLineNum = 65;BA.debugLine="NV.Put(\"hargaitem\", txtHargaitem.Text)";
Debug.ShouldStop(1);
_nv.runVoidMethod ("Put",(Object)(RemoteObject.createImmutable(("hargaitem"))),(Object)((parent.mostCurrent._txthargaitem.runMethod(true,"getText"))));
 BA.debugLineNum = 66;BA.debugLine="j.PostMultipart(\"http://192.168.102.50/b4a_ws/i";
Debug.ShouldStop(2);
_j.runClassMethod (b4a.example.httpjob.class, "_postmultipart" /*RemoteObject*/ ,(Object)(BA.ObjectToString("http://192.168.102.50/b4a_ws/insert.php")),(Object)(_nv),RemoteObject.declareNull("anywheresoftware.b4a.AbsObjectWrapper").runMethod(false, "ConvertToWrapper", RemoteObject.createNew("anywheresoftware.b4a.objects.collections.List"), parent.mostCurrent.__c.getField(false,"Null")));
 BA.debugLineNum = 67;BA.debugLine="Wait For (j) JobDone(j As HttpJob)";
Debug.ShouldStop(4);
parent.mostCurrent.__c.runVoidMethod ("WaitFor","jobdone", atambah.processBA, anywheresoftware.b4a.pc.PCResumableSub.createDebugResumeSub(this, "atambah", "btnsimpan_click"), (_j));
this.state = 22;
return;
case 22:
//C
this.state = 7;
_j = (RemoteObject) result.getArrayElement(false,RemoteObject.createImmutable(0));Debug.locals.put("j", _j);
;
 BA.debugLineNum = 68;BA.debugLine="If j.Success Then";
Debug.ShouldStop(8);
if (true) break;

case 7:
//if
this.state = 16;
if (_j.getField(true,"_success" /*RemoteObject*/ ).<Boolean>get().booleanValue()) { 
this.state = 9;
}if (true) break;

case 9:
//C
this.state = 10;
 BA.debugLineNum = 70;BA.debugLine="ProgressDialogHide";
Debug.ShouldStop(32);
parent.mostCurrent.__c.runVoidMethod ("ProgressDialogHide");
 BA.debugLineNum = 71;BA.debugLine="Log(j.GetString)";
Debug.ShouldStop(64);
parent.mostCurrent.__c.runVoidMethod ("LogImpl","124772628",_j.runClassMethod (b4a.example.httpjob.class, "_getstring" /*RemoteObject*/ ),0);
 BA.debugLineNum = 73;BA.debugLine="If j.GetString == \"sukses\" Then";
Debug.ShouldStop(256);
if (true) break;

case 10:
//if
this.state = 15;
if (RemoteObject.solveBoolean("=",_j.runClassMethod (b4a.example.httpjob.class, "_getstring" /*RemoteObject*/ ),BA.ObjectToString("sukses"))) { 
this.state = 12;
}else {
this.state = 14;
}if (true) break;

case 12:
//C
this.state = 15;
 BA.debugLineNum = 74;BA.debugLine="txtKodeitem.Text = \"\"";
Debug.ShouldStop(512);
parent.mostCurrent._txtkodeitem.runMethod(true,"setText",RemoteObject.createImmutable(("")));
 BA.debugLineNum = 75;BA.debugLine="txtNamaitem.Text = \"\"";
Debug.ShouldStop(1024);
parent.mostCurrent._txtnamaitem.runMethod(true,"setText",RemoteObject.createImmutable(("")));
 BA.debugLineNum = 76;BA.debugLine="txtHargaitem.Text = \"\"";
Debug.ShouldStop(2048);
parent.mostCurrent._txthargaitem.runMethod(true,"setText",RemoteObject.createImmutable(("")));
 BA.debugLineNum = 77;BA.debugLine="ToastMessageShow(\"Berhasil tambah data..\", Tr";
Debug.ShouldStop(4096);
parent.mostCurrent.__c.runVoidMethod ("ToastMessageShow",(Object)(BA.ObjectToCharSequence("Berhasil tambah data..")),(Object)(parent.mostCurrent.__c.getField(true,"True")));
 if (true) break;

case 14:
//C
this.state = 15;
 BA.debugLineNum = 79;BA.debugLine="ToastMessageShow(j.GetString, True)";
Debug.ShouldStop(16384);
parent.mostCurrent.__c.runVoidMethod ("ToastMessageShow",(Object)(BA.ObjectToCharSequence(_j.runClassMethod (b4a.example.httpjob.class, "_getstring" /*RemoteObject*/ ))),(Object)(parent.mostCurrent.__c.getField(true,"True")));
 if (true) break;

case 15:
//C
this.state = 16;
;
 if (true) break;

case 16:
//C
this.state = 19;
;
 BA.debugLineNum = 83;BA.debugLine="j.Release";
Debug.ShouldStop(262144);
_j.runClassMethod (b4a.example.httpjob.class, "_release" /*RemoteObject*/ );
 Debug.CheckDeviceExceptions();
if (true) break;

case 18:
//C
this.state = 19;
this.catchState = 0;
 BA.debugLineNum = 85;BA.debugLine="ToastMessageShow(LastException, True)";
Debug.ShouldStop(1048576);
parent.mostCurrent.__c.runVoidMethod ("ToastMessageShow",(Object)(BA.ObjectToCharSequence(parent.mostCurrent.__c.runMethod(false,"LastException",atambah.mostCurrent.activityBA).getObject())),(Object)(parent.mostCurrent.__c.getField(true,"True")));
 BA.debugLineNum = 86;BA.debugLine="Log(LastException)";
Debug.ShouldStop(2097152);
parent.mostCurrent.__c.runVoidMethod ("LogImpl","124772643",BA.ObjectToString(parent.mostCurrent.__c.runMethod(false,"LastException",atambah.mostCurrent.activityBA)),0);
 if (true) break;
if (true) break;

case 19:
//C
this.state = 20;
this.catchState = 0;
;
 if (true) break;

case 20:
//C
this.state = -1;
;
 BA.debugLineNum = 90;BA.debugLine="End Sub";
Debug.ShouldStop(33554432);
if (true) break;
}} 
       catch (Exception e0) {
			
if (catchState == 0)
    throw e0;
else {
    state = catchState;
BA.rdebugUtils.runVoidMethod("setLastException",atambah.processBA, e0.toString());}
            }
        }
    }
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
}
public static void  _msgbox_result(RemoteObject _result) throws Exception{
}
public static void  _jobdone(RemoteObject _j) throws Exception{
}
public static RemoteObject  _globals() throws Exception{
 //BA.debugLineNum = 10;BA.debugLine="Sub Globals";
 //BA.debugLineNum = 13;BA.debugLine="Private txtKodeitem As FloatLabeledEditText";
atambah.mostCurrent._txtkodeitem = RemoteObject.createNew ("anywheresoftware.b4a.objects.FloatLabeledEditTextWrapper");
 //BA.debugLineNum = 14;BA.debugLine="Private txtNamaitem As FloatLabeledEditText";
atambah.mostCurrent._txtnamaitem = RemoteObject.createNew ("anywheresoftware.b4a.objects.FloatLabeledEditTextWrapper");
 //BA.debugLineNum = 15;BA.debugLine="Private txtHargaitem As FloatLabeledEditText";
atambah.mostCurrent._txthargaitem = RemoteObject.createNew ("anywheresoftware.b4a.objects.FloatLabeledEditTextWrapper");
 //BA.debugLineNum = 16;BA.debugLine="Private btnKembali As Button";
atambah.mostCurrent._btnkembali = RemoteObject.createNew ("anywheresoftware.b4a.objects.ButtonWrapper");
 //BA.debugLineNum = 17;BA.debugLine="Private btnSimpan As Button";
atambah.mostCurrent._btnsimpan = RemoteObject.createNew ("anywheresoftware.b4a.objects.ButtonWrapper");
 //BA.debugLineNum = 18;BA.debugLine="End Sub";
return RemoteObject.createImmutable("");
}
public static RemoteObject  _process_globals() throws Exception{
 //BA.debugLineNum = 6;BA.debugLine="Sub Process_Globals";
 //BA.debugLineNum = 8;BA.debugLine="End Sub";
return RemoteObject.createImmutable("");
}
}