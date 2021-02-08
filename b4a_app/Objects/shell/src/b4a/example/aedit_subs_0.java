package b4a.example;

import anywheresoftware.b4a.BA;
import anywheresoftware.b4a.pc.*;

public class aedit_subs_0 {


public static void  _activity_create(RemoteObject _firsttime) throws Exception{
try {
		Debug.PushSubsStack("Activity_Create (aedit) ","aedit",5,aedit.mostCurrent.activityBA,aedit.mostCurrent,21);
if (RapidSub.canDelegate("activity_create")) { b4a.example.aedit.remoteMe.runUserSub(false, "aedit","activity_create", _firsttime); return;}
ResumableSub_Activity_Create rsub = new ResumableSub_Activity_Create(null,_firsttime);
rsub.resume(null, null);
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static class ResumableSub_Activity_Create extends BA.ResumableSub {
public ResumableSub_Activity_Create(b4a.example.aedit parent,RemoteObject _firsttime) {
this.parent = parent;
this._firsttime = _firsttime;
}
java.util.LinkedHashMap<String, Object> rsLocals = new java.util.LinkedHashMap<String, Object>();
b4a.example.aedit parent;
RemoteObject _firsttime;
RemoteObject _result = RemoteObject.createImmutable(0);

@Override
public void resume(BA ba, RemoteObject result) throws Exception{
try {
		Debug.PushSubsStack("Activity_Create (aedit) ","aedit",5,aedit.mostCurrent.activityBA,aedit.mostCurrent,21);
Debug.locals = rsLocals;Debug.currentSubFrame.locals = rsLocals;

    while (true) {
        switch (state) {
            case -1:
return;

case 0:
//C
this.state = -1;
Debug.locals.put("FirstTime", _firsttime);
 BA.debugLineNum = 22;BA.debugLine="Activity.LoadLayout(\"vEDIT\")";
Debug.ShouldStop(2097152);
parent.mostCurrent._activity.runMethodAndSync(false,"LoadLayout",(Object)(RemoteObject.createImmutable("vEDIT")),aedit.mostCurrent.activityBA);
 BA.debugLineNum = 23;BA.debugLine="Activity.Title = \"Edit Data\"";
Debug.ShouldStop(4194304);
parent.mostCurrent._activity.runMethod(false,"setTitle",BA.ObjectToCharSequence("Edit Data"));
 BA.debugLineNum = 25;BA.debugLine="txtKodeitem.Enabled = False";
Debug.ShouldStop(16777216);
parent.mostCurrent._txtkodeitem.runMethod(true,"setEnabled",parent.mostCurrent.__c.getField(true,"False"));
 BA.debugLineNum = 26;BA.debugLine="txtKodeitem.Hint = \"Kodeitem\"";
Debug.ShouldStop(33554432);
parent.mostCurrent._txtkodeitem.runMethod(true,"setHint",BA.ObjectToString("Kodeitem"));
 BA.debugLineNum = 27;BA.debugLine="txtKodeitem.SetLayout(10dip, 10dip, 95%x, 55dip)";
Debug.ShouldStop(67108864);
parent.mostCurrent._txtkodeitem.runVoidMethod ("SetLayout",(Object)(parent.mostCurrent.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, 10)))),(Object)(parent.mostCurrent.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, 10)))),(Object)(parent.mostCurrent.__c.runMethod(true,"PerXToCurrent",(Object)(BA.numberCast(float.class, 95)),aedit.mostCurrent.activityBA)),(Object)(parent.mostCurrent.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, 55)))));
 BA.debugLineNum = 29;BA.debugLine="txtNamaitem.Hint = \"Namaitem\"";
Debug.ShouldStop(268435456);
parent.mostCurrent._txtnamaitem.runMethod(true,"setHint",BA.ObjectToString("Namaitem"));
 BA.debugLineNum = 30;BA.debugLine="txtNamaitem.SetLayout(10dip, txtKodeitem.Top + tx";
Debug.ShouldStop(536870912);
parent.mostCurrent._txtnamaitem.runVoidMethod ("SetLayout",(Object)(parent.mostCurrent.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, 10)))),(Object)(RemoteObject.solve(new RemoteObject[] {parent.mostCurrent._txtkodeitem.runMethod(true,"getTop"),parent.mostCurrent._txtkodeitem.runMethod(true,"getHeight")}, "+",1, 1)),(Object)(parent.mostCurrent.__c.runMethod(true,"PerXToCurrent",(Object)(BA.numberCast(float.class, 95)),aedit.mostCurrent.activityBA)),(Object)(parent.mostCurrent.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, 55)))));
 BA.debugLineNum = 32;BA.debugLine="txtHargaitem.Hint = \"Hargaitem\"";
Debug.ShouldStop(-2147483648);
parent.mostCurrent._txthargaitem.runMethod(true,"setHint",BA.ObjectToString("Hargaitem"));
 BA.debugLineNum = 33;BA.debugLine="txtHargaitem.EditText.InputType = txtHargaitem.Ed";
Debug.ShouldStop(1);
parent.mostCurrent._txthargaitem.runMethod(false,"getEditText").runMethod(true,"setInputType",parent.mostCurrent._txthargaitem.runMethod(false,"getEditText").getField(true,"INPUT_TYPE_NUMBERS"));
 BA.debugLineNum = 34;BA.debugLine="txtHargaitem.SetLayout(10dip, txtNamaitem.Top + t";
Debug.ShouldStop(2);
parent.mostCurrent._txthargaitem.runVoidMethod ("SetLayout",(Object)(parent.mostCurrent.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, 10)))),(Object)(RemoteObject.solve(new RemoteObject[] {parent.mostCurrent._txtnamaitem.runMethod(true,"getTop"),parent.mostCurrent._txtnamaitem.runMethod(true,"getHeight")}, "+",1, 1)),(Object)(parent.mostCurrent.__c.runMethod(true,"PerXToCurrent",(Object)(BA.numberCast(float.class, 95)),aedit.mostCurrent.activityBA)),(Object)(parent.mostCurrent.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, 55)))));
 BA.debugLineNum = 36;BA.debugLine="btnKembali.Text = \"Kembali\"";
Debug.ShouldStop(8);
parent.mostCurrent._btnkembali.runMethod(true,"setText",BA.ObjectToCharSequence("Kembali"));
 BA.debugLineNum = 37;BA.debugLine="btnKembali.SetLayout(10dip, txtHargaitem.Top + tx";
Debug.ShouldStop(16);
parent.mostCurrent._btnkembali.runVoidMethod ("SetLayout",(Object)(parent.mostCurrent.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, 10)))),(Object)(RemoteObject.solve(new RemoteObject[] {parent.mostCurrent._txthargaitem.runMethod(true,"getTop"),parent.mostCurrent._txthargaitem.runMethod(true,"getHeight")}, "+",1, 1)),(Object)(parent.mostCurrent.__c.runMethod(true,"PerXToCurrent",(Object)(BA.numberCast(float.class, 25)),aedit.mostCurrent.activityBA)),(Object)(parent.mostCurrent.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, 55)))));
 BA.debugLineNum = 39;BA.debugLine="btnHapus.Text = \"Hapus\"";
Debug.ShouldStop(64);
parent.mostCurrent._btnhapus.runMethod(true,"setText",BA.ObjectToCharSequence("Hapus"));
 BA.debugLineNum = 40;BA.debugLine="btnHapus.Color = Colors.Red";
Debug.ShouldStop(128);
parent.mostCurrent._btnhapus.runVoidMethod ("setColor",parent.mostCurrent.__c.getField(false,"Colors").getField(true,"Red"));
 BA.debugLineNum = 41;BA.debugLine="btnHapus.TextColor = Colors.White";
Debug.ShouldStop(256);
parent.mostCurrent._btnhapus.runMethod(true,"setTextColor",parent.mostCurrent.__c.getField(false,"Colors").getField(true,"White"));
 BA.debugLineNum = 42;BA.debugLine="btnHapus.SetLayout(btnKembali.Left + btnKembali.W";
Debug.ShouldStop(512);
parent.mostCurrent._btnhapus.runVoidMethod ("SetLayout",(Object)(RemoteObject.solve(new RemoteObject[] {parent.mostCurrent._btnkembali.runMethod(true,"getLeft"),parent.mostCurrent._btnkembali.runMethod(true,"getWidth")}, "+",1, 1)),(Object)(RemoteObject.solve(new RemoteObject[] {parent.mostCurrent._txthargaitem.runMethod(true,"getTop"),parent.mostCurrent._txthargaitem.runMethod(true,"getHeight")}, "+",1, 1)),(Object)(parent.mostCurrent.__c.runMethod(true,"PerXToCurrent",(Object)(BA.numberCast(float.class, 25)),aedit.mostCurrent.activityBA)),(Object)(parent.mostCurrent.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, 55)))));
 BA.debugLineNum = 44;BA.debugLine="btnSimpan.Text = \"Simpan\"";
Debug.ShouldStop(2048);
parent.mostCurrent._btnsimpan.runMethod(true,"setText",BA.ObjectToCharSequence("Simpan"));
 BA.debugLineNum = 45;BA.debugLine="btnSimpan.SetLayout(btnHapus.Left + btnHapus.Widt";
Debug.ShouldStop(4096);
parent.mostCurrent._btnsimpan.runVoidMethod ("SetLayout",(Object)(RemoteObject.solve(new RemoteObject[] {parent.mostCurrent._btnhapus.runMethod(true,"getLeft"),parent.mostCurrent._btnhapus.runMethod(true,"getWidth")}, "+",1, 1)),(Object)(RemoteObject.solve(new RemoteObject[] {parent.mostCurrent._txthargaitem.runMethod(true,"getTop"),parent.mostCurrent._txthargaitem.runMethod(true,"getHeight")}, "+",1, 1)),(Object)(parent.mostCurrent.__c.runMethod(true,"PerXToCurrent",(Object)(BA.numberCast(float.class, 25)),aedit.mostCurrent.activityBA)),(Object)(parent.mostCurrent.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, 55)))));
 BA.debugLineNum = 47;BA.debugLine="ProgressDialogShow(\"Loading..\")";
Debug.ShouldStop(16384);
parent.mostCurrent.__c.runVoidMethod ("ProgressDialogShow",aedit.mostCurrent.activityBA,(Object)(BA.ObjectToCharSequence(RemoteObject.createImmutable("Loading.."))));
 BA.debugLineNum = 48;BA.debugLine="Wait For(detaildata) Complete (Result As Int)";
Debug.ShouldStop(32768);
parent.mostCurrent.__c.runVoidMethod ("WaitFor","complete", aedit.processBA, anywheresoftware.b4a.pc.PCResumableSub.createDebugResumeSub(this, "aedit", "activity_create"), _detaildata());
this.state = 1;
return;
case 1:
//C
this.state = -1;
_result = (RemoteObject) result.getArrayElement(true,RemoteObject.createImmutable(0));Debug.locals.put("Result", _result);
;
 BA.debugLineNum = 49;BA.debugLine="ProgressDialogHide";
Debug.ShouldStop(65536);
parent.mostCurrent.__c.runVoidMethod ("ProgressDialogHide");
 BA.debugLineNum = 50;BA.debugLine="End Sub";
Debug.ShouldStop(131072);
if (true) break;

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
public static void  _complete(RemoteObject _result) throws Exception{
}
public static RemoteObject  _activity_pause(RemoteObject _userclosed) throws Exception{
try {
		Debug.PushSubsStack("Activity_Pause (aedit) ","aedit",5,aedit.mostCurrent.activityBA,aedit.mostCurrent,56);
if (RapidSub.canDelegate("activity_pause")) { return b4a.example.aedit.remoteMe.runUserSub(false, "aedit","activity_pause", _userclosed);}
Debug.locals.put("UserClosed", _userclosed);
 BA.debugLineNum = 56;BA.debugLine="Sub Activity_Pause (UserClosed As Boolean)";
Debug.ShouldStop(8388608);
 BA.debugLineNum = 58;BA.debugLine="End Sub";
Debug.ShouldStop(33554432);
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
		Debug.PushSubsStack("Activity_Resume (aedit) ","aedit",5,aedit.mostCurrent.activityBA,aedit.mostCurrent,52);
if (RapidSub.canDelegate("activity_resume")) { return b4a.example.aedit.remoteMe.runUserSub(false, "aedit","activity_resume");}
 BA.debugLineNum = 52;BA.debugLine="Sub Activity_Resume";
Debug.ShouldStop(524288);
 BA.debugLineNum = 54;BA.debugLine="End Sub";
Debug.ShouldStop(2097152);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static void  _btnhapus_click() throws Exception{
try {
		Debug.PushSubsStack("btnHapus_Click (aedit) ","aedit",5,aedit.mostCurrent.activityBA,aedit.mostCurrent,155);
if (RapidSub.canDelegate("btnhapus_click")) { b4a.example.aedit.remoteMe.runUserSub(false, "aedit","btnhapus_click"); return;}
ResumableSub_btnHapus_Click rsub = new ResumableSub_btnHapus_Click(null);
rsub.resume(null, null);
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static class ResumableSub_btnHapus_Click extends BA.ResumableSub {
public ResumableSub_btnHapus_Click(b4a.example.aedit parent) {
this.parent = parent;
}
java.util.LinkedHashMap<String, Object> rsLocals = new java.util.LinkedHashMap<String, Object>();
b4a.example.aedit parent;
RemoteObject _result = RemoteObject.createImmutable(0);
RemoteObject _nv = RemoteObject.declareNull("anywheresoftware.b4a.objects.collections.Map");
RemoteObject _j = RemoteObject.declareNull("b4a.example.httpjob");

@Override
public void resume(BA ba, RemoteObject result) throws Exception{
try {
		Debug.PushSubsStack("btnHapus_Click (aedit) ","aedit",5,aedit.mostCurrent.activityBA,aedit.mostCurrent,155);
Debug.locals = rsLocals;Debug.currentSubFrame.locals = rsLocals;

    while (true) {
try {

        switch (state) {
            case -1:
return;

case 0:
//C
this.state = 1;
 BA.debugLineNum = 156;BA.debugLine="Msgbox2Async(\"Hapus data ini ?.\", \"KONFIRMASI\", \"";
Debug.ShouldStop(134217728);
parent.mostCurrent.__c.runVoidMethod ("Msgbox2Async",(Object)(BA.ObjectToCharSequence("Hapus data ini ?.")),(Object)(BA.ObjectToCharSequence("KONFIRMASI")),(Object)(BA.ObjectToString("Ya")),(Object)(BA.ObjectToString("Tidak")),(Object)(BA.ObjectToString("")),RemoteObject.declareNull("anywheresoftware.b4a.AbsObjectWrapper").runMethod(false, "ConvertToWrapper", RemoteObject.createNew("anywheresoftware.b4a.objects.drawable.CanvasWrapper.BitmapWrapper"), parent.mostCurrent.__c.getField(false,"Null")),aedit.processBA,(Object)(parent.mostCurrent.__c.getField(true,"True")));
 BA.debugLineNum = 157;BA.debugLine="Wait For Msgbox_Result(Result As Int)";
Debug.ShouldStop(268435456);
parent.mostCurrent.__c.runVoidMethod ("WaitFor","msgbox_result", aedit.processBA, anywheresoftware.b4a.pc.PCResumableSub.createDebugResumeSub(this, "aedit", "btnhapus_click"), null);
this.state = 21;
return;
case 21:
//C
this.state = 1;
_result = (RemoteObject) result.getArrayElement(true,RemoteObject.createImmutable(0));Debug.locals.put("Result", _result);
;
 BA.debugLineNum = 158;BA.debugLine="If Result = DialogResponse.POSITIVE Then";
Debug.ShouldStop(536870912);
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
 BA.debugLineNum = 160;BA.debugLine="Try";
Debug.ShouldStop(-2147483648);
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
 BA.debugLineNum = 161;BA.debugLine="ProgressDialogShow(\"Proses..\")";
Debug.ShouldStop(1);
parent.mostCurrent.__c.runVoidMethod ("ProgressDialogShow",aedit.mostCurrent.activityBA,(Object)(BA.ObjectToCharSequence(RemoteObject.createImmutable("Proses.."))));
 BA.debugLineNum = 162;BA.debugLine="Dim NV As Map";
Debug.ShouldStop(2);
_nv = RemoteObject.createNew ("anywheresoftware.b4a.objects.collections.Map");Debug.locals.put("NV", _nv);
 BA.debugLineNum = 163;BA.debugLine="Dim j As HttpJob";
Debug.ShouldStop(4);
_j = RemoteObject.createNew ("b4a.example.httpjob");Debug.locals.put("j", _j);
 BA.debugLineNum = 165;BA.debugLine="j.Initialize(\"\", Me)";
Debug.ShouldStop(16);
_j.runClassMethod (b4a.example.httpjob.class, "_initialize" /*RemoteObject*/ ,aedit.processBA,(Object)(BA.ObjectToString("")),(Object)(aedit.getObject()));
 BA.debugLineNum = 166;BA.debugLine="NV.Initialize";
Debug.ShouldStop(32);
_nv.runVoidMethod ("Initialize");
 BA.debugLineNum = 167;BA.debugLine="NV.Put(\"kodeitem\", kodeitem)";
Debug.ShouldStop(64);
_nv.runVoidMethod ("Put",(Object)(RemoteObject.createImmutable(("kodeitem"))),(Object)((parent._kodeitem)));
 BA.debugLineNum = 168;BA.debugLine="j.PostMultipart(\"http://192.168.102.50/b4a_ws/d";
Debug.ShouldStop(128);
_j.runClassMethod (b4a.example.httpjob.class, "_postmultipart" /*RemoteObject*/ ,(Object)(BA.ObjectToString("http://192.168.102.50/b4a_ws/delete.php")),(Object)(_nv),RemoteObject.declareNull("anywheresoftware.b4a.AbsObjectWrapper").runMethod(false, "ConvertToWrapper", RemoteObject.createNew("anywheresoftware.b4a.objects.collections.List"), parent.mostCurrent.__c.getField(false,"Null")));
 BA.debugLineNum = 169;BA.debugLine="Wait For (j) JobDone(j As HttpJob)";
Debug.ShouldStop(256);
parent.mostCurrent.__c.runVoidMethod ("WaitFor","jobdone", aedit.processBA, anywheresoftware.b4a.pc.PCResumableSub.createDebugResumeSub(this, "aedit", "btnhapus_click"), (_j));
this.state = 22;
return;
case 22:
//C
this.state = 7;
_j = (RemoteObject) result.getArrayElement(false,RemoteObject.createImmutable(0));Debug.locals.put("j", _j);
;
 BA.debugLineNum = 170;BA.debugLine="If j.Success Then";
Debug.ShouldStop(512);
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
 BA.debugLineNum = 172;BA.debugLine="ProgressDialogHide";
Debug.ShouldStop(2048);
parent.mostCurrent.__c.runVoidMethod ("ProgressDialogHide");
 BA.debugLineNum = 173;BA.debugLine="Log(j.GetString)";
Debug.ShouldStop(4096);
parent.mostCurrent.__c.runVoidMethod ("LogImpl","128704786",_j.runClassMethod (b4a.example.httpjob.class, "_getstring" /*RemoteObject*/ ),0);
 BA.debugLineNum = 175;BA.debugLine="If j.GetString == \"sukses\" Then";
Debug.ShouldStop(16384);
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
 BA.debugLineNum = 176;BA.debugLine="StartActivity(aLIST)";
Debug.ShouldStop(32768);
parent.mostCurrent.__c.runVoidMethod ("StartActivity",aedit.processBA,(Object)((parent.mostCurrent._alist.getObject())));
 BA.debugLineNum = 177;BA.debugLine="Activity.Finish";
Debug.ShouldStop(65536);
parent.mostCurrent._activity.runVoidMethod ("Finish");
 if (true) break;

case 14:
//C
this.state = 15;
 BA.debugLineNum = 179;BA.debugLine="ToastMessageShow(j.GetString, True)";
Debug.ShouldStop(262144);
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
 BA.debugLineNum = 183;BA.debugLine="j.Release";
Debug.ShouldStop(4194304);
_j.runClassMethod (b4a.example.httpjob.class, "_release" /*RemoteObject*/ );
 Debug.CheckDeviceExceptions();
if (true) break;

case 18:
//C
this.state = 19;
this.catchState = 0;
 BA.debugLineNum = 185;BA.debugLine="ToastMessageShow(LastException, True)";
Debug.ShouldStop(16777216);
parent.mostCurrent.__c.runVoidMethod ("ToastMessageShow",(Object)(BA.ObjectToCharSequence(parent.mostCurrent.__c.runMethod(false,"LastException",aedit.mostCurrent.activityBA).getObject())),(Object)(parent.mostCurrent.__c.getField(true,"True")));
 BA.debugLineNum = 186;BA.debugLine="Log(LastException)";
Debug.ShouldStop(33554432);
parent.mostCurrent.__c.runVoidMethod ("LogImpl","128704799",BA.ObjectToString(parent.mostCurrent.__c.runMethod(false,"LastException",aedit.mostCurrent.activityBA)),0);
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
 BA.debugLineNum = 190;BA.debugLine="End Sub";
Debug.ShouldStop(536870912);
if (true) break;
}} 
       catch (Exception e0) {
			
if (catchState == 0)
    throw e0;
else {
    state = catchState;
BA.rdebugUtils.runVoidMethod("setLastException",aedit.processBA, e0.toString());}
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
public static RemoteObject  _btnkembali_click() throws Exception{
try {
		Debug.PushSubsStack("btnKembali_Click (aedit) ","aedit",5,aedit.mostCurrent.activityBA,aedit.mostCurrent,151);
if (RapidSub.canDelegate("btnkembali_click")) { return b4a.example.aedit.remoteMe.runUserSub(false, "aedit","btnkembali_click");}
 BA.debugLineNum = 151;BA.debugLine="Private Sub btnKembali_Click";
Debug.ShouldStop(4194304);
 BA.debugLineNum = 152;BA.debugLine="StartActivity(aLIST)";
Debug.ShouldStop(8388608);
aedit.mostCurrent.__c.runVoidMethod ("StartActivity",aedit.processBA,(Object)((aedit.mostCurrent._alist.getObject())));
 BA.debugLineNum = 153;BA.debugLine="End Sub";
Debug.ShouldStop(16777216);
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
		Debug.PushSubsStack("btnSimpan_Click (aedit) ","aedit",5,aedit.mostCurrent.activityBA,aedit.mostCurrent,62);
if (RapidSub.canDelegate("btnsimpan_click")) { b4a.example.aedit.remoteMe.runUserSub(false, "aedit","btnsimpan_click"); return;}
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
public ResumableSub_btnSimpan_Click(b4a.example.aedit parent) {
this.parent = parent;
}
java.util.LinkedHashMap<String, Object> rsLocals = new java.util.LinkedHashMap<String, Object>();
b4a.example.aedit parent;
RemoteObject _result = RemoteObject.createImmutable(0);
RemoteObject _nv = RemoteObject.declareNull("anywheresoftware.b4a.objects.collections.Map");
RemoteObject _j = RemoteObject.declareNull("b4a.example.httpjob");

@Override
public void resume(BA ba, RemoteObject result) throws Exception{
try {
		Debug.PushSubsStack("btnSimpan_Click (aedit) ","aedit",5,aedit.mostCurrent.activityBA,aedit.mostCurrent,62);
Debug.locals = rsLocals;Debug.currentSubFrame.locals = rsLocals;

    while (true) {
try {

        switch (state) {
            case -1:
return;

case 0:
//C
this.state = 1;
 BA.debugLineNum = 63;BA.debugLine="Msgbox2Async(\"Simpan data sekarang.\", \"KONFIRMASI";
Debug.ShouldStop(1073741824);
parent.mostCurrent.__c.runVoidMethod ("Msgbox2Async",(Object)(BA.ObjectToCharSequence("Simpan data sekarang.")),(Object)(BA.ObjectToCharSequence("KONFIRMASI")),(Object)(BA.ObjectToString("Ya")),(Object)(BA.ObjectToString("Tidak")),(Object)(BA.ObjectToString("")),RemoteObject.declareNull("anywheresoftware.b4a.AbsObjectWrapper").runMethod(false, "ConvertToWrapper", RemoteObject.createNew("anywheresoftware.b4a.objects.drawable.CanvasWrapper.BitmapWrapper"), parent.mostCurrent.__c.getField(false,"Null")),aedit.processBA,(Object)(parent.mostCurrent.__c.getField(true,"True")));
 BA.debugLineNum = 64;BA.debugLine="Wait For Msgbox_Result(Result As Int)";
Debug.ShouldStop(-2147483648);
parent.mostCurrent.__c.runVoidMethod ("WaitFor","msgbox_result", aedit.processBA, anywheresoftware.b4a.pc.PCResumableSub.createDebugResumeSub(this, "aedit", "btnsimpan_click"), null);
this.state = 21;
return;
case 21:
//C
this.state = 1;
_result = (RemoteObject) result.getArrayElement(true,RemoteObject.createImmutable(0));Debug.locals.put("Result", _result);
;
 BA.debugLineNum = 65;BA.debugLine="If Result = DialogResponse.POSITIVE Then";
Debug.ShouldStop(1);
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
 BA.debugLineNum = 67;BA.debugLine="Try";
Debug.ShouldStop(4);
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
 BA.debugLineNum = 68;BA.debugLine="ProgressDialogShow(\"Proses..\")";
Debug.ShouldStop(8);
parent.mostCurrent.__c.runVoidMethod ("ProgressDialogShow",aedit.mostCurrent.activityBA,(Object)(BA.ObjectToCharSequence(RemoteObject.createImmutable("Proses.."))));
 BA.debugLineNum = 69;BA.debugLine="Dim NV As Map";
Debug.ShouldStop(16);
_nv = RemoteObject.createNew ("anywheresoftware.b4a.objects.collections.Map");Debug.locals.put("NV", _nv);
 BA.debugLineNum = 70;BA.debugLine="Dim j As HttpJob";
Debug.ShouldStop(32);
_j = RemoteObject.createNew ("b4a.example.httpjob");Debug.locals.put("j", _j);
 BA.debugLineNum = 72;BA.debugLine="j.Initialize(\"\", Me)";
Debug.ShouldStop(128);
_j.runClassMethod (b4a.example.httpjob.class, "_initialize" /*RemoteObject*/ ,aedit.processBA,(Object)(BA.ObjectToString("")),(Object)(aedit.getObject()));
 BA.debugLineNum = 73;BA.debugLine="NV.Initialize";
Debug.ShouldStop(256);
_nv.runVoidMethod ("Initialize");
 BA.debugLineNum = 74;BA.debugLine="NV.Put(\"kodeitem\", txtKodeitem.Text)";
Debug.ShouldStop(512);
_nv.runVoidMethod ("Put",(Object)(RemoteObject.createImmutable(("kodeitem"))),(Object)((parent.mostCurrent._txtkodeitem.runMethod(true,"getText"))));
 BA.debugLineNum = 75;BA.debugLine="NV.Put(\"namaitem\", txtNamaitem.Text)";
Debug.ShouldStop(1024);
_nv.runVoidMethod ("Put",(Object)(RemoteObject.createImmutable(("namaitem"))),(Object)((parent.mostCurrent._txtnamaitem.runMethod(true,"getText"))));
 BA.debugLineNum = 76;BA.debugLine="NV.Put(\"hargaitem\", txtHargaitem.Text)";
Debug.ShouldStop(2048);
_nv.runVoidMethod ("Put",(Object)(RemoteObject.createImmutable(("hargaitem"))),(Object)((parent.mostCurrent._txthargaitem.runMethod(true,"getText"))));
 BA.debugLineNum = 77;BA.debugLine="j.PostMultipart(\"http://192.168.102.50/b4a_ws/u";
Debug.ShouldStop(4096);
_j.runClassMethod (b4a.example.httpjob.class, "_postmultipart" /*RemoteObject*/ ,(Object)(BA.ObjectToString("http://192.168.102.50/b4a_ws/update.php")),(Object)(_nv),RemoteObject.declareNull("anywheresoftware.b4a.AbsObjectWrapper").runMethod(false, "ConvertToWrapper", RemoteObject.createNew("anywheresoftware.b4a.objects.collections.List"), parent.mostCurrent.__c.getField(false,"Null")));
 BA.debugLineNum = 78;BA.debugLine="Wait For (j) JobDone(j As HttpJob)";
Debug.ShouldStop(8192);
parent.mostCurrent.__c.runVoidMethod ("WaitFor","jobdone", aedit.processBA, anywheresoftware.b4a.pc.PCResumableSub.createDebugResumeSub(this, "aedit", "btnsimpan_click"), (_j));
this.state = 22;
return;
case 22:
//C
this.state = 7;
_j = (RemoteObject) result.getArrayElement(false,RemoteObject.createImmutable(0));Debug.locals.put("j", _j);
;
 BA.debugLineNum = 79;BA.debugLine="If j.Success Then";
Debug.ShouldStop(16384);
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
 BA.debugLineNum = 81;BA.debugLine="ProgressDialogHide";
Debug.ShouldStop(65536);
parent.mostCurrent.__c.runVoidMethod ("ProgressDialogHide");
 BA.debugLineNum = 82;BA.debugLine="Log(j.GetString)";
Debug.ShouldStop(131072);
parent.mostCurrent.__c.runVoidMethod ("LogImpl","128573716",_j.runClassMethod (b4a.example.httpjob.class, "_getstring" /*RemoteObject*/ ),0);
 BA.debugLineNum = 84;BA.debugLine="If j.GetString == \"sukses\" Then";
Debug.ShouldStop(524288);
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
 BA.debugLineNum = 85;BA.debugLine="ToastMessageShow(\"Berhasil update data..\", Tr";
Debug.ShouldStop(1048576);
parent.mostCurrent.__c.runVoidMethod ("ToastMessageShow",(Object)(BA.ObjectToCharSequence("Berhasil update data..")),(Object)(parent.mostCurrent.__c.getField(true,"True")));
 if (true) break;

case 14:
//C
this.state = 15;
 BA.debugLineNum = 87;BA.debugLine="ToastMessageShow(j.GetString, True)";
Debug.ShouldStop(4194304);
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
 BA.debugLineNum = 91;BA.debugLine="j.Release";
Debug.ShouldStop(67108864);
_j.runClassMethod (b4a.example.httpjob.class, "_release" /*RemoteObject*/ );
 Debug.CheckDeviceExceptions();
if (true) break;

case 18:
//C
this.state = 19;
this.catchState = 0;
 BA.debugLineNum = 93;BA.debugLine="ToastMessageShow(LastException, True)";
Debug.ShouldStop(268435456);
parent.mostCurrent.__c.runVoidMethod ("ToastMessageShow",(Object)(BA.ObjectToCharSequence(parent.mostCurrent.__c.runMethod(false,"LastException",aedit.mostCurrent.activityBA).getObject())),(Object)(parent.mostCurrent.__c.getField(true,"True")));
 BA.debugLineNum = 94;BA.debugLine="Log(LastException)";
Debug.ShouldStop(536870912);
parent.mostCurrent.__c.runVoidMethod ("LogImpl","128573728",BA.ObjectToString(parent.mostCurrent.__c.runMethod(false,"LastException",aedit.mostCurrent.activityBA)),0);
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
 BA.debugLineNum = 98;BA.debugLine="End Sub";
Debug.ShouldStop(2);
if (true) break;
}} 
       catch (Exception e0) {
			
if (catchState == 0)
    throw e0;
else {
    state = catchState;
BA.rdebugUtils.runVoidMethod("setLastException",aedit.processBA, e0.toString());}
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
public static RemoteObject  _detaildata() throws Exception{
try {
		Debug.PushSubsStack("detaildata (aedit) ","aedit",5,aedit.mostCurrent.activityBA,aedit.mostCurrent,100);
if (RapidSub.canDelegate("detaildata")) { return b4a.example.aedit.remoteMe.runUserSub(false, "aedit","detaildata");}
ResumableSub_detaildata rsub = new ResumableSub_detaildata(null);
rsub.remoteResumableSub = anywheresoftware.b4a.pc.PCResumableSub.createDebugResumeSubForFilter();
rsub.resume(null, null);
return RemoteObject.declareNull("anywheresoftware.b4a.AbsObjectWrapper").runMethod(false, "ConvertToWrapper", RemoteObject.createNew("anywheresoftware.b4a.keywords.Common.ResumableSubWrapper"), rsub.remoteResumableSub);
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static class ResumableSub_detaildata extends BA.ResumableSub {
public ResumableSub_detaildata(b4a.example.aedit parent) {
this.parent = parent;
}
java.util.LinkedHashMap<String, Object> rsLocals = new java.util.LinkedHashMap<String, Object>();
b4a.example.aedit parent;
RemoteObject _nv = RemoteObject.declareNull("anywheresoftware.b4a.objects.collections.Map");
RemoteObject _j = RemoteObject.declareNull("b4a.example.httpjob");
RemoteObject _jp = RemoteObject.declareNull("anywheresoftware.b4a.objects.collections.JSONParser");
RemoteObject _rows = RemoteObject.declareNull("anywheresoftware.b4a.objects.collections.List");
RemoteObject _row = RemoteObject.declareNull("anywheresoftware.b4a.objects.collections.Map");
RemoteObject group20;
int index20;
int groupLen20;

@Override
public void resume(BA ba, RemoteObject result) throws Exception{
try {
		Debug.PushSubsStack("detaildata (aedit) ","aedit",5,aedit.mostCurrent.activityBA,aedit.mostCurrent,100);
Debug.locals = rsLocals;Debug.currentSubFrame.locals = rsLocals;

    while (true) {
try {

        switch (state) {
            case -1:
{
parent.mostCurrent.__c.runVoidMethod ("ReturnFromResumableSub",this.remoteResumableSub,RemoteObject.createImmutable(null));return;}
case 0:
//C
this.state = 1;
 BA.debugLineNum = 102;BA.debugLine="Try";
Debug.ShouldStop(32);
if (true) break;

case 1:
//try
this.state = 18;
this.catchState = 17;
this.state = 3;
if (true) break;

case 3:
//C
this.state = 4;
this.catchState = 17;
 BA.debugLineNum = 103;BA.debugLine="ProgressDialogShow(\"Proses..\")";
Debug.ShouldStop(64);
parent.mostCurrent.__c.runVoidMethod ("ProgressDialogShow",aedit.mostCurrent.activityBA,(Object)(BA.ObjectToCharSequence(RemoteObject.createImmutable("Proses.."))));
 BA.debugLineNum = 104;BA.debugLine="Dim NV As Map";
Debug.ShouldStop(128);
_nv = RemoteObject.createNew ("anywheresoftware.b4a.objects.collections.Map");Debug.locals.put("NV", _nv);
 BA.debugLineNum = 105;BA.debugLine="Dim j As HttpJob";
Debug.ShouldStop(256);
_j = RemoteObject.createNew ("b4a.example.httpjob");Debug.locals.put("j", _j);
 BA.debugLineNum = 107;BA.debugLine="j.Initialize(\"\", Me)";
Debug.ShouldStop(1024);
_j.runClassMethod (b4a.example.httpjob.class, "_initialize" /*RemoteObject*/ ,aedit.processBA,(Object)(BA.ObjectToString("")),(Object)(aedit.getObject()));
 BA.debugLineNum = 108;BA.debugLine="NV.Initialize";
Debug.ShouldStop(2048);
_nv.runVoidMethod ("Initialize");
 BA.debugLineNum = 109;BA.debugLine="NV.Put(\"kodeitem\", kodeitem)";
Debug.ShouldStop(4096);
_nv.runVoidMethod ("Put",(Object)(RemoteObject.createImmutable(("kodeitem"))),(Object)((parent._kodeitem)));
 BA.debugLineNum = 110;BA.debugLine="j.PostMultipart(\"http://192.168.102.50/b4a_ws/de";
Debug.ShouldStop(8192);
_j.runClassMethod (b4a.example.httpjob.class, "_postmultipart" /*RemoteObject*/ ,(Object)(BA.ObjectToString("http://192.168.102.50/b4a_ws/detail.php")),(Object)(_nv),RemoteObject.declareNull("anywheresoftware.b4a.AbsObjectWrapper").runMethod(false, "ConvertToWrapper", RemoteObject.createNew("anywheresoftware.b4a.objects.collections.List"), parent.mostCurrent.__c.getField(false,"Null")));
 BA.debugLineNum = 111;BA.debugLine="Wait For (j) JobDone(j As HttpJob)";
Debug.ShouldStop(16384);
parent.mostCurrent.__c.runVoidMethod ("WaitFor","jobdone", aedit.processBA, anywheresoftware.b4a.pc.PCResumableSub.createDebugResumeSub(this, "aedit", "detaildata"), (_j));
this.state = 19;
return;
case 19:
//C
this.state = 4;
_j = (RemoteObject) result.getArrayElement(false,RemoteObject.createImmutable(0));Debug.locals.put("j", _j);
;
 BA.debugLineNum = 112;BA.debugLine="If j.Success Then";
Debug.ShouldStop(32768);
if (true) break;

case 4:
//if
this.state = 15;
if (_j.getField(true,"_success" /*RemoteObject*/ ).<Boolean>get().booleanValue()) { 
this.state = 6;
}if (true) break;

case 6:
//C
this.state = 7;
 BA.debugLineNum = 114;BA.debugLine="ProgressDialogHide";
Debug.ShouldStop(131072);
parent.mostCurrent.__c.runVoidMethod ("ProgressDialogHide");
 BA.debugLineNum = 116;BA.debugLine="Log(j.GetString)";
Debug.ShouldStop(524288);
parent.mostCurrent.__c.runVoidMethod ("LogImpl","129425680",_j.runClassMethod (b4a.example.httpjob.class, "_getstring" /*RemoteObject*/ ),0);
 BA.debugLineNum = 117;BA.debugLine="If j.GetString = Null Or j.GetString = \"[]\" The";
Debug.ShouldStop(1048576);
if (true) break;

case 7:
//if
this.state = 10;
if (RemoteObject.solveBoolean("n",_j.runClassMethod (b4a.example.httpjob.class, "_getstring" /*RemoteObject*/ )) || RemoteObject.solveBoolean("=",_j.runClassMethod (b4a.example.httpjob.class, "_getstring" /*RemoteObject*/ ),BA.ObjectToString("[]"))) { 
this.state = 9;
}if (true) break;

case 9:
//C
this.state = 10;
 BA.debugLineNum = 118;BA.debugLine="ToastMessageShow(\"Tidak ada data yang ditampil";
Debug.ShouldStop(2097152);
parent.mostCurrent.__c.runVoidMethod ("ToastMessageShow",(Object)(BA.ObjectToCharSequence("Tidak ada data yang ditampilkan")),(Object)(parent.mostCurrent.__c.getField(true,"False")));
 BA.debugLineNum = 119;BA.debugLine="Return 0";
Debug.ShouldStop(4194304);
Debug.CheckDeviceExceptions();if (true) {
parent.mostCurrent.__c.runVoidMethod ("ReturnFromResumableSub",this.remoteResumableSub,RemoteObject.createImmutable((0)));return;};
 if (true) break;

case 10:
//C
this.state = 11;
;
 BA.debugLineNum = 122;BA.debugLine="Dim jp As JSONParser";
Debug.ShouldStop(33554432);
_jp = RemoteObject.createNew ("anywheresoftware.b4a.objects.collections.JSONParser");Debug.locals.put("jp", _jp);
 BA.debugLineNum = 123;BA.debugLine="jp.Initialize(j.GetString)";
Debug.ShouldStop(67108864);
_jp.runVoidMethod ("Initialize",(Object)(_j.runClassMethod (b4a.example.httpjob.class, "_getstring" /*RemoteObject*/ )));
 BA.debugLineNum = 124;BA.debugLine="Dim rows As List = jp.NextArray";
Debug.ShouldStop(134217728);
_rows = RemoteObject.createNew ("anywheresoftware.b4a.objects.collections.List");
_rows = _jp.runMethod(false,"NextArray");Debug.locals.put("rows", _rows);Debug.locals.put("rows", _rows);
 BA.debugLineNum = 127;BA.debugLine="For Each row As Map In rows";
Debug.ShouldStop(1073741824);
if (true) break;

case 11:
//for
this.state = 14;
_row = RemoteObject.createNew ("anywheresoftware.b4a.objects.collections.Map");
group20 = _rows;
index20 = 0;
groupLen20 = group20.runMethod(true,"getSize").<Integer>get();
Debug.locals.put("row", _row);
this.state = 20;
if (true) break;

case 20:
//C
this.state = 14;
if (index20 < groupLen20) {
this.state = 13;
_row = RemoteObject.declareNull("anywheresoftware.b4a.AbsObjectWrapper").runMethod(false, "ConvertToWrapper", RemoteObject.createNew("anywheresoftware.b4a.objects.collections.Map"), group20.runMethod(false,"Get",index20));}
if (true) break;

case 21:
//C
this.state = 20;
index20++;
Debug.locals.put("row", _row);
if (true) break;

case 13:
//C
this.state = 21;
 BA.debugLineNum = 129;BA.debugLine="txtKodeitem.Text = row.Get(\"kodeitem\")";
Debug.ShouldStop(1);
parent.mostCurrent._txtkodeitem.runMethod(true,"setText",_row.runMethod(false,"Get",(Object)((RemoteObject.createImmutable("kodeitem")))));
 BA.debugLineNum = 130;BA.debugLine="txtNamaitem.Text = row.Get(\"namaitem\")";
Debug.ShouldStop(2);
parent.mostCurrent._txtnamaitem.runMethod(true,"setText",_row.runMethod(false,"Get",(Object)((RemoteObject.createImmutable("namaitem")))));
 BA.debugLineNum = 131;BA.debugLine="txtHargaitem.Text = row.Get(\"hargaitem\")";
Debug.ShouldStop(4);
parent.mostCurrent._txthargaitem.runMethod(true,"setText",_row.runMethod(false,"Get",(Object)((RemoteObject.createImmutable("hargaitem")))));
 if (true) break;
if (true) break;

case 14:
//C
this.state = 15;
Debug.locals.put("row", _row);
;
 if (true) break;

case 15:
//C
this.state = 18;
;
 BA.debugLineNum = 136;BA.debugLine="j.Release";
Debug.ShouldStop(128);
_j.runClassMethod (b4a.example.httpjob.class, "_release" /*RemoteObject*/ );
 BA.debugLineNum = 138;BA.debugLine="Log(\"Selesai Load\")";
Debug.ShouldStop(512);
parent.mostCurrent.__c.runVoidMethod ("LogImpl","129425702",RemoteObject.createImmutable("Selesai Load"),0);
 Debug.CheckDeviceExceptions();
if (true) break;

case 17:
//C
this.state = 18;
this.catchState = 0;
 BA.debugLineNum = 142;BA.debugLine="ProgressDialogHide";
Debug.ShouldStop(8192);
parent.mostCurrent.__c.runVoidMethod ("ProgressDialogHide");
 BA.debugLineNum = 143;BA.debugLine="ToastMessageShow(LastException, True)";
Debug.ShouldStop(16384);
parent.mostCurrent.__c.runVoidMethod ("ToastMessageShow",(Object)(BA.ObjectToCharSequence(parent.mostCurrent.__c.runMethod(false,"LastException",aedit.mostCurrent.activityBA).getObject())),(Object)(parent.mostCurrent.__c.getField(true,"True")));
 BA.debugLineNum = 144;BA.debugLine="Log(LastException)";
Debug.ShouldStop(32768);
parent.mostCurrent.__c.runVoidMethod ("LogImpl","129425708",BA.ObjectToString(parent.mostCurrent.__c.runMethod(false,"LastException",aedit.mostCurrent.activityBA)),0);
 if (true) break;
if (true) break;

case 18:
//C
this.state = -1;
this.catchState = 0;
;
 BA.debugLineNum = 147;BA.debugLine="Return 0";
Debug.ShouldStop(262144);
Debug.CheckDeviceExceptions();if (true) {
parent.mostCurrent.__c.runVoidMethod ("ReturnFromResumableSub",this.remoteResumableSub,RemoteObject.createImmutable((0)));return;};
 BA.debugLineNum = 149;BA.debugLine="End Sub";
Debug.ShouldStop(1048576);
if (true) break;
}} 
       catch (Exception e0) {
			
if (catchState == 0)
    throw e0;
else {
    state = catchState;
BA.rdebugUtils.runVoidMethod("setLastException",aedit.processBA, e0.toString());}
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
public static RemoteObject  _globals() throws Exception{
 //BA.debugLineNum = 10;BA.debugLine="Sub Globals";
 //BA.debugLineNum = 13;BA.debugLine="Private txtKodeitem As FloatLabeledEditText";
aedit.mostCurrent._txtkodeitem = RemoteObject.createNew ("anywheresoftware.b4a.objects.FloatLabeledEditTextWrapper");
 //BA.debugLineNum = 14;BA.debugLine="Private txtNamaitem As FloatLabeledEditText";
aedit.mostCurrent._txtnamaitem = RemoteObject.createNew ("anywheresoftware.b4a.objects.FloatLabeledEditTextWrapper");
 //BA.debugLineNum = 15;BA.debugLine="Private txtHargaitem As FloatLabeledEditText";
aedit.mostCurrent._txthargaitem = RemoteObject.createNew ("anywheresoftware.b4a.objects.FloatLabeledEditTextWrapper");
 //BA.debugLineNum = 16;BA.debugLine="Private btnKembali As Button";
aedit.mostCurrent._btnkembali = RemoteObject.createNew ("anywheresoftware.b4a.objects.ButtonWrapper");
 //BA.debugLineNum = 17;BA.debugLine="Private btnSimpan As Button";
aedit.mostCurrent._btnsimpan = RemoteObject.createNew ("anywheresoftware.b4a.objects.ButtonWrapper");
 //BA.debugLineNum = 18;BA.debugLine="Private btnHapus As Button";
aedit.mostCurrent._btnhapus = RemoteObject.createNew ("anywheresoftware.b4a.objects.ButtonWrapper");
 //BA.debugLineNum = 19;BA.debugLine="End Sub";
return RemoteObject.createImmutable("");
}
public static RemoteObject  _process_globals() throws Exception{
 //BA.debugLineNum = 6;BA.debugLine="Sub Process_Globals";
 //BA.debugLineNum = 7;BA.debugLine="Public kodeitem As String = \"\"";
aedit._kodeitem = BA.ObjectToString("");
 //BA.debugLineNum = 8;BA.debugLine="End Sub";
return RemoteObject.createImmutable("");
}
}