package b4a.example;


import anywheresoftware.b4a.B4AMenuItem;
import android.app.Activity;
import android.os.Bundle;
import anywheresoftware.b4a.BA;
import anywheresoftware.b4a.BALayout;
import anywheresoftware.b4a.B4AActivity;
import anywheresoftware.b4a.ObjectWrapper;
import anywheresoftware.b4a.objects.ActivityWrapper;
import java.lang.reflect.InvocationTargetException;
import anywheresoftware.b4a.B4AUncaughtException;
import anywheresoftware.b4a.debug.*;
import java.lang.ref.WeakReference;

public class alist extends Activity implements B4AActivity{
	public static alist mostCurrent;
	static boolean afterFirstLayout;
	static boolean isFirst = true;
    private static boolean processGlobalsRun = false;
	BALayout layout;
	public static BA processBA;
	BA activityBA;
    ActivityWrapper _activity;
    java.util.ArrayList<B4AMenuItem> menuItems;
	public static final boolean fullScreen = false;
	public static final boolean includeTitle = true;
    public static WeakReference<Activity> previousOne;
    public static boolean dontPause;

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
        mostCurrent = this;
		if (processBA == null) {
			processBA = new anywheresoftware.b4a.ShellBA(this.getApplicationContext(), null, null, "b4a.example", "b4a.example.alist");
			processBA.loadHtSubs(this.getClass());
	        float deviceScale = getApplicationContext().getResources().getDisplayMetrics().density;
	        BALayout.setDeviceScale(deviceScale);
            
		}
		else if (previousOne != null) {
			Activity p = previousOne.get();
			if (p != null && p != this) {
                BA.LogInfo("Killing previous instance (alist).");
				p.finish();
			}
		}
        processBA.setActivityPaused(true);
        processBA.runHook("oncreate", this, null);
		if (!includeTitle) {
        	this.getWindow().requestFeature(android.view.Window.FEATURE_NO_TITLE);
        }
        if (fullScreen) {
        	getWindow().setFlags(android.view.WindowManager.LayoutParams.FLAG_FULLSCREEN,   
        			android.view.WindowManager.LayoutParams.FLAG_FULLSCREEN);
        }
		
        processBA.sharedProcessBA.activityBA = null;
		layout = new BALayout(this);
		setContentView(layout);
		afterFirstLayout = false;
        WaitForLayout wl = new WaitForLayout();
        if (anywheresoftware.b4a.objects.ServiceHelper.StarterHelper.startFromActivity(this, processBA, wl, false))
		    BA.handler.postDelayed(wl, 5);

	}
	static class WaitForLayout implements Runnable {
		public void run() {
			if (afterFirstLayout)
				return;
			if (mostCurrent == null)
				return;
            
			if (mostCurrent.layout.getWidth() == 0) {
				BA.handler.postDelayed(this, 5);
				return;
			}
			mostCurrent.layout.getLayoutParams().height = mostCurrent.layout.getHeight();
			mostCurrent.layout.getLayoutParams().width = mostCurrent.layout.getWidth();
			afterFirstLayout = true;
			mostCurrent.afterFirstLayout();
		}
	}
	private void afterFirstLayout() {
        if (this != mostCurrent)
			return;
		activityBA = new BA(this, layout, processBA, "b4a.example", "b4a.example.alist");
        
        processBA.sharedProcessBA.activityBA = new java.lang.ref.WeakReference<BA>(activityBA);
        anywheresoftware.b4a.objects.ViewWrapper.lastId = 0;
        _activity = new ActivityWrapper(activityBA, "activity");
        anywheresoftware.b4a.Msgbox.isDismissing = false;
        if (BA.isShellModeRuntimeCheck(processBA)) {
			if (isFirst)
				processBA.raiseEvent2(null, true, "SHELL", false);
			processBA.raiseEvent2(null, true, "CREATE", true, "b4a.example.alist", processBA, activityBA, _activity, anywheresoftware.b4a.keywords.Common.Density, mostCurrent);
			_activity.reinitializeForShell(activityBA, "activity");
		}
        initializeProcessGlobals();		
        initializeGlobals();
        
        BA.LogInfo("** Activity (alist) Create, isFirst = " + isFirst + " **");
        processBA.raiseEvent2(null, true, "activity_create", false, isFirst);
		isFirst = false;
		if (this != mostCurrent)
			return;
        processBA.setActivityPaused(false);
        BA.LogInfo("** Activity (alist) Resume **");
        processBA.raiseEvent(null, "activity_resume");
        if (android.os.Build.VERSION.SDK_INT >= 11) {
			try {
				android.app.Activity.class.getMethod("invalidateOptionsMenu").invoke(this,(Object[]) null);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

	}
	public void addMenuItem(B4AMenuItem item) {
		if (menuItems == null)
			menuItems = new java.util.ArrayList<B4AMenuItem>();
		menuItems.add(item);
	}
	@Override
	public boolean onCreateOptionsMenu(android.view.Menu menu) {
		super.onCreateOptionsMenu(menu);
        try {
            if (processBA.subExists("activity_actionbarhomeclick")) {
                Class.forName("android.app.ActionBar").getMethod("setHomeButtonEnabled", boolean.class).invoke(
                    getClass().getMethod("getActionBar").invoke(this), true);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        if (processBA.runHook("oncreateoptionsmenu", this, new Object[] {menu}))
            return true;
		if (menuItems == null)
			return false;
		for (B4AMenuItem bmi : menuItems) {
			android.view.MenuItem mi = menu.add(bmi.title);
			if (bmi.drawable != null)
				mi.setIcon(bmi.drawable);
            if (android.os.Build.VERSION.SDK_INT >= 11) {
				try {
                    if (bmi.addToBar) {
				        android.view.MenuItem.class.getMethod("setShowAsAction", int.class).invoke(mi, 1);
                    }
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
			mi.setOnMenuItemClickListener(new B4AMenuItemsClickListener(bmi.eventName.toLowerCase(BA.cul)));
		}
        
		return true;
	}   
 @Override
 public boolean onOptionsItemSelected(android.view.MenuItem item) {
    if (item.getItemId() == 16908332) {
        processBA.raiseEvent(null, "activity_actionbarhomeclick");
        return true;
    }
    else
        return super.onOptionsItemSelected(item); 
}
@Override
 public boolean onPrepareOptionsMenu(android.view.Menu menu) {
    super.onPrepareOptionsMenu(menu);
    processBA.runHook("onprepareoptionsmenu", this, new Object[] {menu});
    return true;
    
 }
 protected void onStart() {
    super.onStart();
    processBA.runHook("onstart", this, null);
}
 protected void onStop() {
    super.onStop();
    processBA.runHook("onstop", this, null);
}
    public void onWindowFocusChanged(boolean hasFocus) {
       super.onWindowFocusChanged(hasFocus);
       if (processBA.subExists("activity_windowfocuschanged"))
           processBA.raiseEvent2(null, true, "activity_windowfocuschanged", false, hasFocus);
    }
	private class B4AMenuItemsClickListener implements android.view.MenuItem.OnMenuItemClickListener {
		private final String eventName;
		public B4AMenuItemsClickListener(String eventName) {
			this.eventName = eventName;
		}
		public boolean onMenuItemClick(android.view.MenuItem item) {
			processBA.raiseEventFromUI(item.getTitle(), eventName + "_click");
			return true;
		}
	}
    public static Class<?> getObject() {
		return alist.class;
	}
    private Boolean onKeySubExist = null;
    private Boolean onKeyUpSubExist = null;
	@Override
	public boolean onKeyDown(int keyCode, android.view.KeyEvent event) {
        if (processBA.runHook("onkeydown", this, new Object[] {keyCode, event}))
            return true;
		if (onKeySubExist == null)
			onKeySubExist = processBA.subExists("activity_keypress");
		if (onKeySubExist) {
			if (keyCode == anywheresoftware.b4a.keywords.constants.KeyCodes.KEYCODE_BACK &&
					android.os.Build.VERSION.SDK_INT >= 18) {
				HandleKeyDelayed hk = new HandleKeyDelayed();
				hk.kc = keyCode;
				BA.handler.post(hk);
				return true;
			}
			else {
				boolean res = new HandleKeyDelayed().runDirectly(keyCode);
				if (res)
					return true;
			}
		}
		return super.onKeyDown(keyCode, event);
	}
	private class HandleKeyDelayed implements Runnable {
		int kc;
		public void run() {
			runDirectly(kc);
		}
		public boolean runDirectly(int keyCode) {
			Boolean res =  (Boolean)processBA.raiseEvent2(_activity, false, "activity_keypress", false, keyCode);
			if (res == null || res == true) {
                return true;
            }
            else if (keyCode == anywheresoftware.b4a.keywords.constants.KeyCodes.KEYCODE_BACK) {
				finish();
				return true;
			}
            return false;
		}
		
	}
    @Override
	public boolean onKeyUp(int keyCode, android.view.KeyEvent event) {
        if (processBA.runHook("onkeyup", this, new Object[] {keyCode, event}))
            return true;
		if (onKeyUpSubExist == null)
			onKeyUpSubExist = processBA.subExists("activity_keyup");
		if (onKeyUpSubExist) {
			Boolean res =  (Boolean)processBA.raiseEvent2(_activity, false, "activity_keyup", false, keyCode);
			if (res == null || res == true)
				return true;
		}
		return super.onKeyUp(keyCode, event);
	}
	@Override
	public void onNewIntent(android.content.Intent intent) {
        super.onNewIntent(intent);
		this.setIntent(intent);
        processBA.runHook("onnewintent", this, new Object[] {intent});
	}
    @Override 
	public void onPause() {
		super.onPause();
        if (_activity == null)
            return;
        if (this != mostCurrent)
			return;
		anywheresoftware.b4a.Msgbox.dismiss(true);
        if (!dontPause)
            BA.LogInfo("** Activity (alist) Pause, UserClosed = " + activityBA.activity.isFinishing() + " **");
        else
            BA.LogInfo("** Activity (alist) Pause event (activity is not paused). **");
        if (mostCurrent != null)
            processBA.raiseEvent2(_activity, true, "activity_pause", false, activityBA.activity.isFinishing());		
        if (!dontPause) {
            processBA.setActivityPaused(true);
            mostCurrent = null;
        }

        if (!activityBA.activity.isFinishing())
			previousOne = new WeakReference<Activity>(this);
        anywheresoftware.b4a.Msgbox.isDismissing = false;
        processBA.runHook("onpause", this, null);
	}

	@Override
	public void onDestroy() {
        super.onDestroy();
		previousOne = null;
        processBA.runHook("ondestroy", this, null);
	}
    @Override 
	public void onResume() {
		super.onResume();
        mostCurrent = this;
        anywheresoftware.b4a.Msgbox.isDismissing = false;
        if (activityBA != null) { //will be null during activity create (which waits for AfterLayout).
        	ResumeMessage rm = new ResumeMessage(mostCurrent);
        	BA.handler.post(rm);
        }
        processBA.runHook("onresume", this, null);
	}
    private static class ResumeMessage implements Runnable {
    	private final WeakReference<Activity> activity;
    	public ResumeMessage(Activity activity) {
    		this.activity = new WeakReference<Activity>(activity);
    	}
		public void run() {
            alist mc = mostCurrent;
			if (mc == null || mc != activity.get())
				return;
			processBA.setActivityPaused(false);
            BA.LogInfo("** Activity (alist) Resume **");
            if (mc != mostCurrent)
                return;
		    processBA.raiseEvent(mc._activity, "activity_resume", (Object[])null);
		}
    }
	@Override
	protected void onActivityResult(int requestCode, int resultCode,
	      android.content.Intent data) {
		processBA.onActivityResult(requestCode, resultCode, data);
        processBA.runHook("onactivityresult", this, new Object[] {requestCode, resultCode});
	}
	private static void initializeGlobals() {
		processBA.raiseEvent2(null, true, "globals", false, (Object[])null);
	}
    public void onRequestPermissionsResult(int requestCode,
        String permissions[], int[] grantResults) {
        for (int i = 0;i < permissions.length;i++) {
            Object[] o = new Object[] {permissions[i], grantResults[i] == 0};
            processBA.raiseEventFromDifferentThread(null,null, 0, "activity_permissionresult", true, o);
        }
            
    }



public static void initializeProcessGlobals() {
             try {
                Class.forName(BA.applicationContext.getPackageName() + ".main").getMethod("initializeProcessGlobals").invoke(null, null);
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
}
public anywheresoftware.b4a.keywords.Common __c = null;
public anywheresoftware.b4a.objects.ButtonWrapper _btntambah = null;
public anywheresoftware.b4a.objects.ButtonWrapper _btncari = null;
public anywheresoftware.b4a.objects.ListViewWrapper _listview1 = null;
public b4a.example.main _main = null;
public b4a.example.starter _starter = null;
public b4a.example.atambah _atambah = null;
public b4a.example.multipartpost _multipartpost = null;
public b4a.example.aedit _aedit = null;
public b4a.example.httputils2service _httputils2service = null;
public static void  _activity_create(boolean _firsttime) throws Exception{
RDebugUtils.currentModule="alist";
if (Debug.shouldDelegate(mostCurrent.activityBA, "activity_create", false))
	 {Debug.delegate(mostCurrent.activityBA, "activity_create", new Object[] {_firsttime}); return;}
ResumableSub_Activity_Create rsub = new ResumableSub_Activity_Create(null,_firsttime);
rsub.resume(processBA, null);
}
public static class ResumableSub_Activity_Create extends BA.ResumableSub {
public ResumableSub_Activity_Create(b4a.example.alist parent,boolean _firsttime) {
this.parent = parent;
this._firsttime = _firsttime;
}
b4a.example.alist parent;
boolean _firsttime;
int _result = 0;

@Override
public void resume(BA ba, Object[] result) throws Exception{
RDebugUtils.currentModule="alist";

    while (true) {
        switch (state) {
            case -1:
return;

case 0:
//C
this.state = -1;
RDebugUtils.currentLine=917506;
 //BA.debugLineNum = 917506;BA.debugLine="Activity.LoadLayout(\"vLIST\")";
parent.mostCurrent._activity.LoadLayout("vLIST",mostCurrent.activityBA);
RDebugUtils.currentLine=917508;
 //BA.debugLineNum = 917508;BA.debugLine="btnTambah.Text = \"Tambah Data\"";
parent.mostCurrent._btntambah.setText(BA.ObjectToCharSequence("Tambah Data"));
RDebugUtils.currentLine=917509;
 //BA.debugLineNum = 917509;BA.debugLine="btnTambah.SetLayout(10dip, 10dip, 35%x, 55dip)";
parent.mostCurrent._btntambah.SetLayout(anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (10)),anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (10)),anywheresoftware.b4a.keywords.Common.PerXToCurrent((float) (35),mostCurrent.activityBA),anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (55)));
RDebugUtils.currentLine=917511;
 //BA.debugLineNum = 917511;BA.debugLine="btnCari.Text = \"Cari\"";
parent.mostCurrent._btncari.setText(BA.ObjectToCharSequence("Cari"));
RDebugUtils.currentLine=917512;
 //BA.debugLineNum = 917512;BA.debugLine="btnCari.SetLayout(btnTambah.Left + btnTambah.Widt";
parent.mostCurrent._btncari.SetLayout((int) (parent.mostCurrent._btntambah.getLeft()+parent.mostCurrent._btntambah.getWidth()+anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (10))),anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (10)),anywheresoftware.b4a.keywords.Common.PerXToCurrent((float) (35),mostCurrent.activityBA),anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (55)));
RDebugUtils.currentLine=917514;
 //BA.debugLineNum = 917514;BA.debugLine="ListView1.SetLayout(10dip, btnTambah.Height + btn";
parent.mostCurrent._listview1.SetLayout(anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (10)),(int) (parent.mostCurrent._btntambah.getHeight()+parent.mostCurrent._btntambah.getHeight()+anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (5))),anywheresoftware.b4a.keywords.Common.PerXToCurrent((float) (95),mostCurrent.activityBA),anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (250)));
RDebugUtils.currentLine=917515;
 //BA.debugLineNum = 917515;BA.debugLine="ListView1.TwoLinesLayout.ItemHeight = 85dip";
parent.mostCurrent._listview1.getTwoLinesLayout().setItemHeight(anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (85)));
RDebugUtils.currentLine=917516;
 //BA.debugLineNum = 917516;BA.debugLine="ListView1.TwoLinesLayout.Label.Top = 5dip";
parent.mostCurrent._listview1.getTwoLinesLayout().Label.setTop(anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (5)));
RDebugUtils.currentLine=917517;
 //BA.debugLineNum = 917517;BA.debugLine="ListView1.TwoLinesLayout.Label.TextColor = Colors";
parent.mostCurrent._listview1.getTwoLinesLayout().Label.setTextColor(anywheresoftware.b4a.keywords.Common.Colors.DarkGray);
RDebugUtils.currentLine=917518;
 //BA.debugLineNum = 917518;BA.debugLine="ListView1.TwoLinesLayout.Label.Height = 25dip";
parent.mostCurrent._listview1.getTwoLinesLayout().Label.setHeight(anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (25)));
RDebugUtils.currentLine=917519;
 //BA.debugLineNum = 917519;BA.debugLine="ListView1.TwoLinesLayout.SecondLabel.Height = 50d";
parent.mostCurrent._listview1.getTwoLinesLayout().SecondLabel.setHeight(anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (50)));
RDebugUtils.currentLine=917521;
 //BA.debugLineNum = 917521;BA.debugLine="ProgressDialogShow(\"Loading..\")";
anywheresoftware.b4a.keywords.Common.ProgressDialogShow(mostCurrent.activityBA,BA.ObjectToCharSequence("Loading.."));
RDebugUtils.currentLine=917522;
 //BA.debugLineNum = 917522;BA.debugLine="Wait For(tampillistdata) Complete (Result As Int)";
anywheresoftware.b4a.keywords.Common.WaitFor("complete", processBA, new anywheresoftware.b4a.shell.DebugResumableSub.DelegatableResumableSub(this, "alist", "activity_create"), _tampillistdata());
this.state = 1;
return;
case 1:
//C
this.state = -1;
_result = (Integer) result[0];
;
RDebugUtils.currentLine=917523;
 //BA.debugLineNum = 917523;BA.debugLine="ProgressDialogHide";
anywheresoftware.b4a.keywords.Common.ProgressDialogHide();
RDebugUtils.currentLine=917525;
 //BA.debugLineNum = 917525;BA.debugLine="End Sub";
if (true) break;

            }
        }
    }
}
public static anywheresoftware.b4a.keywords.Common.ResumableSubWrapper  _tampillistdata() throws Exception{
RDebugUtils.currentModule="alist";
if (Debug.shouldDelegate(mostCurrent.activityBA, "tampillistdata", false))
	 {return ((anywheresoftware.b4a.keywords.Common.ResumableSubWrapper) Debug.delegate(mostCurrent.activityBA, "tampillistdata", null));}
ResumableSub_tampillistdata rsub = new ResumableSub_tampillistdata(null);
rsub.resume(processBA, null);
return (anywheresoftware.b4a.keywords.Common.ResumableSubWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.keywords.Common.ResumableSubWrapper(), rsub);
}
public static class ResumableSub_tampillistdata extends BA.ResumableSub {
public ResumableSub_tampillistdata(b4a.example.alist parent) {
this.parent = parent;
}
b4a.example.alist parent;
anywheresoftware.b4a.objects.collections.Map _nv = null;
b4a.example.httpjob _j = null;
anywheresoftware.b4a.objects.collections.JSONParser _jp = null;
anywheresoftware.b4a.objects.collections.List _rows = null;
anywheresoftware.b4a.objects.collections.Map _row = null;
anywheresoftware.b4a.BA.IterableList group21;
int index21;
int groupLen21;

@Override
public void resume(BA ba, Object[] result) throws Exception{
RDebugUtils.currentModule="alist";

    while (true) {
try {

        switch (state) {
            case -1:
{
anywheresoftware.b4a.keywords.Common.ReturnFromResumableSub(this,null);return;}
case 0:
//C
this.state = 1;
RDebugUtils.currentLine=28114946;
 //BA.debugLineNum = 28114946;BA.debugLine="Try";
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
RDebugUtils.currentLine=28114947;
 //BA.debugLineNum = 28114947;BA.debugLine="ProgressDialogShow(\"Proses..\")";
anywheresoftware.b4a.keywords.Common.ProgressDialogShow(mostCurrent.activityBA,BA.ObjectToCharSequence("Proses.."));
RDebugUtils.currentLine=28114948;
 //BA.debugLineNum = 28114948;BA.debugLine="Dim NV As Map";
_nv = new anywheresoftware.b4a.objects.collections.Map();
RDebugUtils.currentLine=28114949;
 //BA.debugLineNum = 28114949;BA.debugLine="Dim j As HttpJob";
_j = new b4a.example.httpjob();
RDebugUtils.currentLine=28114951;
 //BA.debugLineNum = 28114951;BA.debugLine="j.Initialize(\"\", Me)";
_j._initialize /*String*/ (null,processBA,"",alist.getObject());
RDebugUtils.currentLine=28114952;
 //BA.debugLineNum = 28114952;BA.debugLine="NV.Initialize";
_nv.Initialize();
RDebugUtils.currentLine=28114953;
 //BA.debugLineNum = 28114953;BA.debugLine="NV.Put(\"katakunci\", \"\")";
_nv.Put((Object)("katakunci"),(Object)(""));
RDebugUtils.currentLine=28114954;
 //BA.debugLineNum = 28114954;BA.debugLine="j.PostMultipart(\"http://192.168.102.50/b4a_ws/se";
_j._postmultipart /*String*/ (null,"http://192.168.102.50/b4a_ws/select.php",_nv,(anywheresoftware.b4a.objects.collections.List) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.objects.collections.List(), (java.util.List)(anywheresoftware.b4a.keywords.Common.Null)));
RDebugUtils.currentLine=28114955;
 //BA.debugLineNum = 28114955;BA.debugLine="Wait For (j) JobDone(j As HttpJob)";
anywheresoftware.b4a.keywords.Common.WaitFor("jobdone", processBA, new anywheresoftware.b4a.shell.DebugResumableSub.DelegatableResumableSub(this, "alist", "tampillistdata"), (Object)(_j));
this.state = 19;
return;
case 19:
//C
this.state = 4;
_j = (b4a.example.httpjob) result[0];
;
RDebugUtils.currentLine=28114956;
 //BA.debugLineNum = 28114956;BA.debugLine="If j.Success Then";
if (true) break;

case 4:
//if
this.state = 15;
if (_j._success /*boolean*/ ) { 
this.state = 6;
}if (true) break;

case 6:
//C
this.state = 7;
RDebugUtils.currentLine=28114958;
 //BA.debugLineNum = 28114958;BA.debugLine="ProgressDialogHide";
anywheresoftware.b4a.keywords.Common.ProgressDialogHide();
RDebugUtils.currentLine=28114960;
 //BA.debugLineNum = 28114960;BA.debugLine="Log(j.GetString)";
anywheresoftware.b4a.keywords.Common.LogImpl("128114960",_j._getstring /*String*/ (null),0);
RDebugUtils.currentLine=28114961;
 //BA.debugLineNum = 28114961;BA.debugLine="If j.GetString = Null Or j.GetString = \"[]\" The";
if (true) break;

case 7:
//if
this.state = 10;
if (_j._getstring /*String*/ (null)== null || (_j._getstring /*String*/ (null)).equals("[]")) { 
this.state = 9;
}if (true) break;

case 9:
//C
this.state = 10;
RDebugUtils.currentLine=28114962;
 //BA.debugLineNum = 28114962;BA.debugLine="ToastMessageShow(\"Tidak ada data yang ditampil";
anywheresoftware.b4a.keywords.Common.ToastMessageShow(BA.ObjectToCharSequence("Tidak ada data yang ditampilkan"),anywheresoftware.b4a.keywords.Common.False);
RDebugUtils.currentLine=28114963;
 //BA.debugLineNum = 28114963;BA.debugLine="Return 0";
if (true) {
anywheresoftware.b4a.keywords.Common.ReturnFromResumableSub(this,(Object)(0));return;};
 if (true) break;

case 10:
//C
this.state = 11;
;
RDebugUtils.currentLine=28114966;
 //BA.debugLineNum = 28114966;BA.debugLine="Dim jp As JSONParser";
_jp = new anywheresoftware.b4a.objects.collections.JSONParser();
RDebugUtils.currentLine=28114967;
 //BA.debugLineNum = 28114967;BA.debugLine="jp.Initialize(j.GetString)";
_jp.Initialize(_j._getstring /*String*/ (null));
RDebugUtils.currentLine=28114968;
 //BA.debugLineNum = 28114968;BA.debugLine="Dim rows As List = jp.NextArray";
_rows = new anywheresoftware.b4a.objects.collections.List();
_rows = _jp.NextArray();
RDebugUtils.currentLine=28114970;
 //BA.debugLineNum = 28114970;BA.debugLine="ListView1.Clear";
parent.mostCurrent._listview1.Clear();
RDebugUtils.currentLine=28114972;
 //BA.debugLineNum = 28114972;BA.debugLine="For Each row As Map In rows";
if (true) break;

case 11:
//for
this.state = 14;
_row = new anywheresoftware.b4a.objects.collections.Map();
group21 = _rows;
index21 = 0;
groupLen21 = group21.getSize();
this.state = 20;
if (true) break;

case 20:
//C
this.state = 14;
if (index21 < groupLen21) {
this.state = 13;
_row = (anywheresoftware.b4a.objects.collections.Map) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.objects.collections.Map(), (anywheresoftware.b4a.objects.collections.Map.MyMap)(group21.Get(index21)));}
if (true) break;

case 21:
//C
this.state = 20;
index21++;
if (true) break;

case 13:
//C
this.state = 21;
RDebugUtils.currentLine=28114974;
 //BA.debugLineNum = 28114974;BA.debugLine="ListView1.AddTwoLines(row.Get(\"kodeitem\"), row";
parent.mostCurrent._listview1.AddTwoLines(BA.ObjectToCharSequence(_row.Get((Object)("kodeitem"))),BA.ObjectToCharSequence(_row.Get((Object)("namaitem"))));
 if (true) break;
if (true) break;

case 14:
//C
this.state = 15;
;
 if (true) break;

case 15:
//C
this.state = 18;
;
RDebugUtils.currentLine=28114979;
 //BA.debugLineNum = 28114979;BA.debugLine="j.Release";
_j._release /*String*/ (null);
RDebugUtils.currentLine=28114981;
 //BA.debugLineNum = 28114981;BA.debugLine="Log(\"Selesai Load\")";
anywheresoftware.b4a.keywords.Common.LogImpl("128114981","Selesai Load",0);
 if (true) break;

case 17:
//C
this.state = 18;
this.catchState = 0;
RDebugUtils.currentLine=28114985;
 //BA.debugLineNum = 28114985;BA.debugLine="ProgressDialogHide";
anywheresoftware.b4a.keywords.Common.ProgressDialogHide();
RDebugUtils.currentLine=28114986;
 //BA.debugLineNum = 28114986;BA.debugLine="ToastMessageShow(LastException, True)";
anywheresoftware.b4a.keywords.Common.ToastMessageShow(BA.ObjectToCharSequence(anywheresoftware.b4a.keywords.Common.LastException(mostCurrent.activityBA).getObject()),anywheresoftware.b4a.keywords.Common.True);
RDebugUtils.currentLine=28114987;
 //BA.debugLineNum = 28114987;BA.debugLine="Log(LastException)";
anywheresoftware.b4a.keywords.Common.LogImpl("128114987",BA.ObjectToString(anywheresoftware.b4a.keywords.Common.LastException(mostCurrent.activityBA)),0);
 if (true) break;
if (true) break;

case 18:
//C
this.state = -1;
this.catchState = 0;
;
RDebugUtils.currentLine=28114990;
 //BA.debugLineNum = 28114990;BA.debugLine="Return 0";
if (true) {
anywheresoftware.b4a.keywords.Common.ReturnFromResumableSub(this,(Object)(0));return;};
RDebugUtils.currentLine=28114992;
 //BA.debugLineNum = 28114992;BA.debugLine="End Sub";
if (true) break;
}} 
       catch (Exception e0) {
			
if (catchState == 0)
    throw e0;
else {
    state = catchState;
processBA.setLastException(e0);}
            }
        }
    }
}
public static String  _activity_pause(boolean _userclosed) throws Exception{
RDebugUtils.currentModule="alist";
RDebugUtils.currentLine=1048576;
 //BA.debugLineNum = 1048576;BA.debugLine="Sub Activity_Pause (UserClosed As Boolean)";
RDebugUtils.currentLine=1048578;
 //BA.debugLineNum = 1048578;BA.debugLine="End Sub";
return "";
}
public static String  _activity_resume() throws Exception{
RDebugUtils.currentModule="alist";
if (Debug.shouldDelegate(mostCurrent.activityBA, "activity_resume", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "activity_resume", null));}
RDebugUtils.currentLine=983040;
 //BA.debugLineNum = 983040;BA.debugLine="Sub Activity_Resume";
RDebugUtils.currentLine=983042;
 //BA.debugLineNum = 983042;BA.debugLine="End Sub";
return "";
}
public static String  _listview1_itemclick(int _position,Object _value) throws Exception{
RDebugUtils.currentModule="alist";
if (Debug.shouldDelegate(mostCurrent.activityBA, "listview1_itemclick", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "listview1_itemclick", new Object[] {_position,_value}));}
RDebugUtils.currentLine=28180480;
 //BA.debugLineNum = 28180480;BA.debugLine="Private Sub ListView1_ItemClick (Position As Int,";
RDebugUtils.currentLine=28180481;
 //BA.debugLineNum = 28180481;BA.debugLine="aEDIT.kodeitem = Value";
mostCurrent._aedit._kodeitem /*String*/  = BA.ObjectToString(_value);
RDebugUtils.currentLine=28180482;
 //BA.debugLineNum = 28180482;BA.debugLine="StartActivity(aEDIT)";
anywheresoftware.b4a.keywords.Common.StartActivity(processBA,(Object)(mostCurrent._aedit.getObject()));
RDebugUtils.currentLine=28180483;
 //BA.debugLineNum = 28180483;BA.debugLine="Activity.Finish";
mostCurrent._activity.Finish();
RDebugUtils.currentLine=28180484;
 //BA.debugLineNum = 28180484;BA.debugLine="End Sub";
return "";
}
}