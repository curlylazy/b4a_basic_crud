package b4a.example;

import anywheresoftware.b4a.BA;
import anywheresoftware.b4a.pc.*;

public class alist_subs_0 {


public static void  _activity_create(RemoteObject _firsttime) throws Exception{
try {
		Debug.PushSubsStack("Activity_Create (alist) ","alist",2,alist.mostCurrent.activityBA,alist.mostCurrent,19);
if (RapidSub.canDelegate("activity_create")) { b4a.example.alist.remoteMe.runUserSub(false, "alist","activity_create", _firsttime); return;}
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
public ResumableSub_Activity_Create(b4a.example.alist parent,RemoteObject _firsttime) {
this.parent = parent;
this._firsttime = _firsttime;
}
java.util.LinkedHashMap<String, Object> rsLocals = new java.util.LinkedHashMap<String, Object>();
b4a.example.alist parent;
RemoteObject _firsttime;
RemoteObject _result = RemoteObject.createImmutable(0);

@Override
public void resume(BA ba, RemoteObject result) throws Exception{
try {
		Debug.PushSubsStack("Activity_Create (alist) ","alist",2,alist.mostCurrent.activityBA,alist.mostCurrent,19);
Debug.locals = rsLocals;Debug.currentSubFrame.locals = rsLocals;

    while (true) {
        switch (state) {
            case -1:
return;

case 0:
//C
this.state = -1;
Debug.locals.put("FirstTime", _firsttime);
 BA.debugLineNum = 21;BA.debugLine="Activity.LoadLayout(\"vLIST\")";
Debug.ShouldStop(1048576);
parent.mostCurrent._activity.runMethodAndSync(false,"LoadLayout",(Object)(RemoteObject.createImmutable("vLIST")),alist.mostCurrent.activityBA);
 BA.debugLineNum = 23;BA.debugLine="btnTambah.Text = \"Tambah Data\"";
Debug.ShouldStop(4194304);
parent.mostCurrent._btntambah.runMethod(true,"setText",BA.ObjectToCharSequence("Tambah Data"));
 BA.debugLineNum = 24;BA.debugLine="btnTambah.SetLayout(10dip, 10dip, 35%x, 55dip)";
Debug.ShouldStop(8388608);
parent.mostCurrent._btntambah.runVoidMethod ("SetLayout",(Object)(parent.mostCurrent.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, 10)))),(Object)(parent.mostCurrent.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, 10)))),(Object)(parent.mostCurrent.__c.runMethod(true,"PerXToCurrent",(Object)(BA.numberCast(float.class, 35)),alist.mostCurrent.activityBA)),(Object)(parent.mostCurrent.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, 55)))));
 BA.debugLineNum = 26;BA.debugLine="btnCari.Text = \"Cari\"";
Debug.ShouldStop(33554432);
parent.mostCurrent._btncari.runMethod(true,"setText",BA.ObjectToCharSequence("Cari"));
 BA.debugLineNum = 27;BA.debugLine="btnCari.SetLayout(btnTambah.Left + btnTambah.Widt";
Debug.ShouldStop(67108864);
parent.mostCurrent._btncari.runVoidMethod ("SetLayout",(Object)(RemoteObject.solve(new RemoteObject[] {parent.mostCurrent._btntambah.runMethod(true,"getLeft"),parent.mostCurrent._btntambah.runMethod(true,"getWidth"),parent.mostCurrent.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, 10)))}, "++",2, 1)),(Object)(parent.mostCurrent.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, 10)))),(Object)(parent.mostCurrent.__c.runMethod(true,"PerXToCurrent",(Object)(BA.numberCast(float.class, 35)),alist.mostCurrent.activityBA)),(Object)(parent.mostCurrent.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, 55)))));
 BA.debugLineNum = 29;BA.debugLine="ListView1.SetLayout(10dip, btnTambah.Height + btn";
Debug.ShouldStop(268435456);
parent.mostCurrent._listview1.runVoidMethod ("SetLayout",(Object)(parent.mostCurrent.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, 10)))),(Object)(RemoteObject.solve(new RemoteObject[] {parent.mostCurrent._btntambah.runMethod(true,"getHeight"),parent.mostCurrent._btntambah.runMethod(true,"getHeight"),parent.mostCurrent.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, 5)))}, "++",2, 1)),(Object)(parent.mostCurrent.__c.runMethod(true,"PerXToCurrent",(Object)(BA.numberCast(float.class, 95)),alist.mostCurrent.activityBA)),(Object)(parent.mostCurrent.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, 250)))));
 BA.debugLineNum = 30;BA.debugLine="ListView1.TwoLinesLayout.ItemHeight = 85dip";
Debug.ShouldStop(536870912);
parent.mostCurrent._listview1.runMethod(false,"getTwoLinesLayout").runMethod(true,"setItemHeight",parent.mostCurrent.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, 85))));
 BA.debugLineNum = 31;BA.debugLine="ListView1.TwoLinesLayout.Label.Top = 5dip";
Debug.ShouldStop(1073741824);
parent.mostCurrent._listview1.runMethod(false,"getTwoLinesLayout").getField(false,"Label").runMethod(true,"setTop",parent.mostCurrent.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, 5))));
 BA.debugLineNum = 32;BA.debugLine="ListView1.TwoLinesLayout.Label.TextColor = Colors";
Debug.ShouldStop(-2147483648);
parent.mostCurrent._listview1.runMethod(false,"getTwoLinesLayout").getField(false,"Label").runMethod(true,"setTextColor",parent.mostCurrent.__c.getField(false,"Colors").getField(true,"DarkGray"));
 BA.debugLineNum = 33;BA.debugLine="ListView1.TwoLinesLayout.Label.Height = 25dip";
Debug.ShouldStop(1);
parent.mostCurrent._listview1.runMethod(false,"getTwoLinesLayout").getField(false,"Label").runMethod(true,"setHeight",parent.mostCurrent.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, 25))));
 BA.debugLineNum = 34;BA.debugLine="ListView1.TwoLinesLayout.SecondLabel.Height = 50d";
Debug.ShouldStop(2);
parent.mostCurrent._listview1.runMethod(false,"getTwoLinesLayout").getField(false,"SecondLabel").runMethod(true,"setHeight",parent.mostCurrent.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, 50))));
 BA.debugLineNum = 36;BA.debugLine="ProgressDialogShow(\"Loading..\")";
Debug.ShouldStop(8);
parent.mostCurrent.__c.runVoidMethod ("ProgressDialogShow",alist.mostCurrent.activityBA,(Object)(BA.ObjectToCharSequence(RemoteObject.createImmutable("Loading.."))));
 BA.debugLineNum = 37;BA.debugLine="Wait For(tampillistdata) Complete (Result As Int)";
Debug.ShouldStop(16);
parent.mostCurrent.__c.runVoidMethod ("WaitFor","complete", alist.processBA, anywheresoftware.b4a.pc.PCResumableSub.createDebugResumeSub(this, "alist", "activity_create"), _tampillistdata());
this.state = 1;
return;
case 1:
//C
this.state = -1;
_result = (RemoteObject) result.getArrayElement(true,RemoteObject.createImmutable(0));Debug.locals.put("Result", _result);
;
 BA.debugLineNum = 38;BA.debugLine="ProgressDialogHide";
Debug.ShouldStop(32);
parent.mostCurrent.__c.runVoidMethod ("ProgressDialogHide");
 BA.debugLineNum = 40;BA.debugLine="End Sub";
Debug.ShouldStop(128);
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
		Debug.PushSubsStack("Activity_Pause (alist) ","alist",2,alist.mostCurrent.activityBA,alist.mostCurrent,46);
if (RapidSub.canDelegate("activity_pause")) { return b4a.example.alist.remoteMe.runUserSub(false, "alist","activity_pause", _userclosed);}
Debug.locals.put("UserClosed", _userclosed);
 BA.debugLineNum = 46;BA.debugLine="Sub Activity_Pause (UserClosed As Boolean)";
Debug.ShouldStop(8192);
 BA.debugLineNum = 48;BA.debugLine="End Sub";
Debug.ShouldStop(32768);
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
		Debug.PushSubsStack("Activity_Resume (alist) ","alist",2,alist.mostCurrent.activityBA,alist.mostCurrent,42);
if (RapidSub.canDelegate("activity_resume")) { return b4a.example.alist.remoteMe.runUserSub(false, "alist","activity_resume");}
 BA.debugLineNum = 42;BA.debugLine="Sub Activity_Resume";
Debug.ShouldStop(512);
 BA.debugLineNum = 44;BA.debugLine="End Sub";
Debug.ShouldStop(2048);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _globals() throws Exception{
 //BA.debugLineNum = 10;BA.debugLine="Sub Globals";
 //BA.debugLineNum = 14;BA.debugLine="Private btnTambah As Button";
alist.mostCurrent._btntambah = RemoteObject.createNew ("anywheresoftware.b4a.objects.ButtonWrapper");
 //BA.debugLineNum = 15;BA.debugLine="Private btnCari As Button";
alist.mostCurrent._btncari = RemoteObject.createNew ("anywheresoftware.b4a.objects.ButtonWrapper");
 //BA.debugLineNum = 16;BA.debugLine="Private ListView1 As ListView";
alist.mostCurrent._listview1 = RemoteObject.createNew ("anywheresoftware.b4a.objects.ListViewWrapper");
 //BA.debugLineNum = 17;BA.debugLine="End Sub";
return RemoteObject.createImmutable("");
}
public static RemoteObject  _listview1_itemclick(RemoteObject _position,RemoteObject _value) throws Exception{
try {
		Debug.PushSubsStack("ListView1_ItemClick (alist) ","alist",2,alist.mostCurrent.activityBA,alist.mostCurrent,101);
if (RapidSub.canDelegate("listview1_itemclick")) { return b4a.example.alist.remoteMe.runUserSub(false, "alist","listview1_itemclick", _position, _value);}
Debug.locals.put("Position", _position);
Debug.locals.put("Value", _value);
 BA.debugLineNum = 101;BA.debugLine="Private Sub ListView1_ItemClick (Position As Int,";
Debug.ShouldStop(16);
 BA.debugLineNum = 102;BA.debugLine="aEDIT.kodeitem = Value";
Debug.ShouldStop(32);
alist.mostCurrent._aedit._kodeitem /*RemoteObject*/  = BA.ObjectToString(_value);
 BA.debugLineNum = 103;BA.debugLine="StartActivity(aEDIT)";
Debug.ShouldStop(64);
alist.mostCurrent.__c.runVoidMethod ("StartActivity",alist.processBA,(Object)((alist.mostCurrent._aedit.getObject())));
 BA.debugLineNum = 104;BA.debugLine="Activity.Finish";
Debug.ShouldStop(128);
alist.mostCurrent._activity.runVoidMethod ("Finish");
 BA.debugLineNum = 105;BA.debugLine="End Sub";
Debug.ShouldStop(256);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _process_globals() throws Exception{
 //BA.debugLineNum = 6;BA.debugLine="Sub Process_Globals";
 //BA.debugLineNum = 8;BA.debugLine="End Sub";
return RemoteObject.createImmutable("");
}
public static RemoteObject  _tampillistdata() throws Exception{
try {
		Debug.PushSubsStack("tampillistdata (alist) ","alist",2,alist.mostCurrent.activityBA,alist.mostCurrent,50);
if (RapidSub.canDelegate("tampillistdata")) { return b4a.example.alist.remoteMe.runUserSub(false, "alist","tampillistdata");}
ResumableSub_tampillistdata rsub = new ResumableSub_tampillistdata(null);
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
public static class ResumableSub_tampillistdata extends BA.ResumableSub {
public ResumableSub_tampillistdata(b4a.example.alist parent) {
this.parent = parent;
}
java.util.LinkedHashMap<String, Object> rsLocals = new java.util.LinkedHashMap<String, Object>();
b4a.example.alist parent;
RemoteObject _nv = RemoteObject.declareNull("anywheresoftware.b4a.objects.collections.Map");
RemoteObject _j = RemoteObject.declareNull("b4a.example.httpjob");
RemoteObject _jp = RemoteObject.declareNull("anywheresoftware.b4a.objects.collections.JSONParser");
RemoteObject _rows = RemoteObject.declareNull("anywheresoftware.b4a.objects.collections.List");
RemoteObject _row = RemoteObject.declareNull("anywheresoftware.b4a.objects.collections.Map");
RemoteObject group21;
int index21;
int groupLen21;

@Override
public void resume(BA ba, RemoteObject result) throws Exception{
try {
		Debug.PushSubsStack("tampillistdata (alist) ","alist",2,alist.mostCurrent.activityBA,alist.mostCurrent,50);
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
 BA.debugLineNum = 52;BA.debugLine="Try";
Debug.ShouldStop(524288);
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
 BA.debugLineNum = 53;BA.debugLine="ProgressDialogShow(\"Proses..\")";
Debug.ShouldStop(1048576);
parent.mostCurrent.__c.runVoidMethod ("ProgressDialogShow",alist.mostCurrent.activityBA,(Object)(BA.ObjectToCharSequence(RemoteObject.createImmutable("Proses.."))));
 BA.debugLineNum = 54;BA.debugLine="Dim NV As Map";
Debug.ShouldStop(2097152);
_nv = RemoteObject.createNew ("anywheresoftware.b4a.objects.collections.Map");Debug.locals.put("NV", _nv);
 BA.debugLineNum = 55;BA.debugLine="Dim j As HttpJob";
Debug.ShouldStop(4194304);
_j = RemoteObject.createNew ("b4a.example.httpjob");Debug.locals.put("j", _j);
 BA.debugLineNum = 57;BA.debugLine="j.Initialize(\"\", Me)";
Debug.ShouldStop(16777216);
_j.runClassMethod (b4a.example.httpjob.class, "_initialize" /*RemoteObject*/ ,alist.processBA,(Object)(BA.ObjectToString("")),(Object)(alist.getObject()));
 BA.debugLineNum = 58;BA.debugLine="NV.Initialize";
Debug.ShouldStop(33554432);
_nv.runVoidMethod ("Initialize");
 BA.debugLineNum = 59;BA.debugLine="NV.Put(\"katakunci\", \"\")";
Debug.ShouldStop(67108864);
_nv.runVoidMethod ("Put",(Object)(RemoteObject.createImmutable(("katakunci"))),(Object)((RemoteObject.createImmutable(""))));
 BA.debugLineNum = 60;BA.debugLine="j.PostMultipart(\"http://192.168.102.50/b4a_ws/se";
Debug.ShouldStop(134217728);
_j.runClassMethod (b4a.example.httpjob.class, "_postmultipart" /*RemoteObject*/ ,(Object)(BA.ObjectToString("http://192.168.102.50/b4a_ws/select.php")),(Object)(_nv),RemoteObject.declareNull("anywheresoftware.b4a.AbsObjectWrapper").runMethod(false, "ConvertToWrapper", RemoteObject.createNew("anywheresoftware.b4a.objects.collections.List"), parent.mostCurrent.__c.getField(false,"Null")));
 BA.debugLineNum = 61;BA.debugLine="Wait For (j) JobDone(j As HttpJob)";
Debug.ShouldStop(268435456);
parent.mostCurrent.__c.runVoidMethod ("WaitFor","jobdone", alist.processBA, anywheresoftware.b4a.pc.PCResumableSub.createDebugResumeSub(this, "alist", "tampillistdata"), (_j));
this.state = 19;
return;
case 19:
//C
this.state = 4;
_j = (RemoteObject) result.getArrayElement(false,RemoteObject.createImmutable(0));Debug.locals.put("j", _j);
;
 BA.debugLineNum = 62;BA.debugLine="If j.Success Then";
Debug.ShouldStop(536870912);
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
 BA.debugLineNum = 64;BA.debugLine="ProgressDialogHide";
Debug.ShouldStop(-2147483648);
parent.mostCurrent.__c.runVoidMethod ("ProgressDialogHide");
 BA.debugLineNum = 66;BA.debugLine="Log(j.GetString)";
Debug.ShouldStop(2);
parent.mostCurrent.__c.runVoidMethod ("LogImpl","128114960",_j.runClassMethod (b4a.example.httpjob.class, "_getstring" /*RemoteObject*/ ),0);
 BA.debugLineNum = 67;BA.debugLine="If j.GetString = Null Or j.GetString = \"[]\" The";
Debug.ShouldStop(4);
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
 BA.debugLineNum = 68;BA.debugLine="ToastMessageShow(\"Tidak ada data yang ditampil";
Debug.ShouldStop(8);
parent.mostCurrent.__c.runVoidMethod ("ToastMessageShow",(Object)(BA.ObjectToCharSequence("Tidak ada data yang ditampilkan")),(Object)(parent.mostCurrent.__c.getField(true,"False")));
 BA.debugLineNum = 69;BA.debugLine="Return 0";
Debug.ShouldStop(16);
Debug.CheckDeviceExceptions();if (true) {
parent.mostCurrent.__c.runVoidMethod ("ReturnFromResumableSub",this.remoteResumableSub,RemoteObject.createImmutable((0)));return;};
 if (true) break;

case 10:
//C
this.state = 11;
;
 BA.debugLineNum = 72;BA.debugLine="Dim jp As JSONParser";
Debug.ShouldStop(128);
_jp = RemoteObject.createNew ("anywheresoftware.b4a.objects.collections.JSONParser");Debug.locals.put("jp", _jp);
 BA.debugLineNum = 73;BA.debugLine="jp.Initialize(j.GetString)";
Debug.ShouldStop(256);
_jp.runVoidMethod ("Initialize",(Object)(_j.runClassMethod (b4a.example.httpjob.class, "_getstring" /*RemoteObject*/ )));
 BA.debugLineNum = 74;BA.debugLine="Dim rows As List = jp.NextArray";
Debug.ShouldStop(512);
_rows = RemoteObject.createNew ("anywheresoftware.b4a.objects.collections.List");
_rows = _jp.runMethod(false,"NextArray");Debug.locals.put("rows", _rows);Debug.locals.put("rows", _rows);
 BA.debugLineNum = 76;BA.debugLine="ListView1.Clear";
Debug.ShouldStop(2048);
parent.mostCurrent._listview1.runVoidMethod ("Clear");
 BA.debugLineNum = 78;BA.debugLine="For Each row As Map In rows";
Debug.ShouldStop(8192);
if (true) break;

case 11:
//for
this.state = 14;
_row = RemoteObject.createNew ("anywheresoftware.b4a.objects.collections.Map");
group21 = _rows;
index21 = 0;
groupLen21 = group21.runMethod(true,"getSize").<Integer>get();
Debug.locals.put("row", _row);
this.state = 20;
if (true) break;

case 20:
//C
this.state = 14;
if (index21 < groupLen21) {
this.state = 13;
_row = RemoteObject.declareNull("anywheresoftware.b4a.AbsObjectWrapper").runMethod(false, "ConvertToWrapper", RemoteObject.createNew("anywheresoftware.b4a.objects.collections.Map"), group21.runMethod(false,"Get",index21));}
if (true) break;

case 21:
//C
this.state = 20;
index21++;
Debug.locals.put("row", _row);
if (true) break;

case 13:
//C
this.state = 21;
 BA.debugLineNum = 80;BA.debugLine="ListView1.AddTwoLines(row.Get(\"kodeitem\"), row";
Debug.ShouldStop(32768);
parent.mostCurrent._listview1.runVoidMethod ("AddTwoLines",(Object)(BA.ObjectToCharSequence(_row.runMethod(false,"Get",(Object)((RemoteObject.createImmutable("kodeitem")))))),(Object)(BA.ObjectToCharSequence(_row.runMethod(false,"Get",(Object)((RemoteObject.createImmutable("namaitem")))))));
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
 BA.debugLineNum = 85;BA.debugLine="j.Release";
Debug.ShouldStop(1048576);
_j.runClassMethod (b4a.example.httpjob.class, "_release" /*RemoteObject*/ );
 BA.debugLineNum = 87;BA.debugLine="Log(\"Selesai Load\")";
Debug.ShouldStop(4194304);
parent.mostCurrent.__c.runVoidMethod ("LogImpl","128114981",RemoteObject.createImmutable("Selesai Load"),0);
 Debug.CheckDeviceExceptions();
if (true) break;

case 17:
//C
this.state = 18;
this.catchState = 0;
 BA.debugLineNum = 91;BA.debugLine="ProgressDialogHide";
Debug.ShouldStop(67108864);
parent.mostCurrent.__c.runVoidMethod ("ProgressDialogHide");
 BA.debugLineNum = 92;BA.debugLine="ToastMessageShow(LastException, True)";
Debug.ShouldStop(134217728);
parent.mostCurrent.__c.runVoidMethod ("ToastMessageShow",(Object)(BA.ObjectToCharSequence(parent.mostCurrent.__c.runMethod(false,"LastException",alist.mostCurrent.activityBA).getObject())),(Object)(parent.mostCurrent.__c.getField(true,"True")));
 BA.debugLineNum = 93;BA.debugLine="Log(LastException)";
Debug.ShouldStop(268435456);
parent.mostCurrent.__c.runVoidMethod ("LogImpl","128114987",BA.ObjectToString(parent.mostCurrent.__c.runMethod(false,"LastException",alist.mostCurrent.activityBA)),0);
 if (true) break;
if (true) break;

case 18:
//C
this.state = -1;
this.catchState = 0;
;
 BA.debugLineNum = 96;BA.debugLine="Return 0";
Debug.ShouldStop(-2147483648);
Debug.CheckDeviceExceptions();if (true) {
parent.mostCurrent.__c.runVoidMethod ("ReturnFromResumableSub",this.remoteResumableSub,RemoteObject.createImmutable((0)));return;};
 BA.debugLineNum = 98;BA.debugLine="End Sub";
Debug.ShouldStop(2);
if (true) break;
}} 
       catch (Exception e0) {
			
if (catchState == 0)
    throw e0;
else {
    state = catchState;
BA.rdebugUtils.runVoidMethod("setLastException",alist.processBA, e0.toString());}
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
public static void  _jobdone(RemoteObject _j) throws Exception{
}
}