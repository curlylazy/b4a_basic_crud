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

public class atambah extends Activity implements B4AActivity{
	public static atambah mostCurrent;
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
			processBA = new anywheresoftware.b4a.ShellBA(this.getApplicationContext(), null, null, "b4a.example", "b4a.example.atambah");
			processBA.loadHtSubs(this.getClass());
	        float deviceScale = getApplicationContext().getResources().getDisplayMetrics().density;
	        BALayout.setDeviceScale(deviceScale);
            
		}
		else if (previousOne != null) {
			Activity p = previousOne.get();
			if (p != null && p != this) {
                BA.LogInfo("Killing previous instance (atambah).");
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
		activityBA = new BA(this, layout, processBA, "b4a.example", "b4a.example.atambah");
        
        processBA.sharedProcessBA.activityBA = new java.lang.ref.WeakReference<BA>(activityBA);
        anywheresoftware.b4a.objects.ViewWrapper.lastId = 0;
        _activity = new ActivityWrapper(activityBA, "activity");
        anywheresoftware.b4a.Msgbox.isDismissing = false;
        if (BA.isShellModeRuntimeCheck(processBA)) {
			if (isFirst)
				processBA.raiseEvent2(null, true, "SHELL", false);
			processBA.raiseEvent2(null, true, "CREATE", true, "b4a.example.atambah", processBA, activityBA, _activity, anywheresoftware.b4a.keywords.Common.Density, mostCurrent);
			_activity.reinitializeForShell(activityBA, "activity");
		}
        initializeProcessGlobals();		
        initializeGlobals();
        
        BA.LogInfo("** Activity (atambah) Create, isFirst = " + isFirst + " **");
        processBA.raiseEvent2(null, true, "activity_create", false, isFirst);
		isFirst = false;
		if (this != mostCurrent)
			return;
        processBA.setActivityPaused(false);
        BA.LogInfo("** Activity (atambah) Resume **");
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
		return atambah.class;
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
            BA.LogInfo("** Activity (atambah) Pause, UserClosed = " + activityBA.activity.isFinishing() + " **");
        else
            BA.LogInfo("** Activity (atambah) Pause event (activity is not paused). **");
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
            atambah mc = mostCurrent;
			if (mc == null || mc != activity.get())
				return;
			processBA.setActivityPaused(false);
            BA.LogInfo("** Activity (atambah) Resume **");
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
public anywheresoftware.b4a.objects.FloatLabeledEditTextWrapper _txtkodeitem = null;
public anywheresoftware.b4a.objects.FloatLabeledEditTextWrapper _txtnamaitem = null;
public anywheresoftware.b4a.objects.FloatLabeledEditTextWrapper _txthargaitem = null;
public anywheresoftware.b4a.objects.ButtonWrapper _btnkembali = null;
public anywheresoftware.b4a.objects.ButtonWrapper _btnsimpan = null;
public b4a.example.main _main = null;
public b4a.example.starter _starter = null;
public b4a.example.alist _alist = null;
public b4a.example.multipartpost _multipartpost = null;
public b4a.example.aedit _aedit = null;
public b4a.example.httputils2service _httputils2service = null;
public static String  _activity_create(boolean _firsttime) throws Exception{
RDebugUtils.currentModule="atambah";
if (Debug.shouldDelegate(mostCurrent.activityBA, "activity_create", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "activity_create", new Object[] {_firsttime}));}
RDebugUtils.currentLine=1310720;
 //BA.debugLineNum = 1310720;BA.debugLine="Sub Activity_Create(FirstTime As Boolean)";
RDebugUtils.currentLine=1310721;
 //BA.debugLineNum = 1310721;BA.debugLine="Activity.LoadLayout(\"vTAMBAH\")";
mostCurrent._activity.LoadLayout("vTAMBAH",mostCurrent.activityBA);
RDebugUtils.currentLine=1310722;
 //BA.debugLineNum = 1310722;BA.debugLine="Activity.Title = \"Tambah Data\"";
mostCurrent._activity.setTitle(BA.ObjectToCharSequence("Tambah Data"));
RDebugUtils.currentLine=1310724;
 //BA.debugLineNum = 1310724;BA.debugLine="txtKodeitem.Hint = \"Kodeitem\"";
mostCurrent._txtkodeitem.setHint("Kodeitem");
RDebugUtils.currentLine=1310725;
 //BA.debugLineNum = 1310725;BA.debugLine="txtKodeitem.SetLayout(10dip, 10dip, 95%x, 55dip)";
mostCurrent._txtkodeitem.SetLayout(anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (10)),anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (10)),anywheresoftware.b4a.keywords.Common.PerXToCurrent((float) (95),mostCurrent.activityBA),anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (55)));
RDebugUtils.currentLine=1310727;
 //BA.debugLineNum = 1310727;BA.debugLine="txtNamaitem.Hint = \"Namaitem\"";
mostCurrent._txtnamaitem.setHint("Namaitem");
RDebugUtils.currentLine=1310728;
 //BA.debugLineNum = 1310728;BA.debugLine="txtNamaitem.SetLayout(10dip, txtKodeitem.Top + tx";
mostCurrent._txtnamaitem.SetLayout(anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (10)),(int) (mostCurrent._txtkodeitem.getTop()+mostCurrent._txtkodeitem.getHeight()),anywheresoftware.b4a.keywords.Common.PerXToCurrent((float) (95),mostCurrent.activityBA),anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (55)));
RDebugUtils.currentLine=1310730;
 //BA.debugLineNum = 1310730;BA.debugLine="txtHargaitem.Hint = \"Hargaitem\"";
mostCurrent._txthargaitem.setHint("Hargaitem");
RDebugUtils.currentLine=1310731;
 //BA.debugLineNum = 1310731;BA.debugLine="txtHargaitem.EditText.InputType = txtHargaitem.Ed";
mostCurrent._txthargaitem.getEditText().setInputType(mostCurrent._txthargaitem.getEditText().INPUT_TYPE_NUMBERS);
RDebugUtils.currentLine=1310732;
 //BA.debugLineNum = 1310732;BA.debugLine="txtHargaitem.SetLayout(10dip, txtNamaitem.Top + t";
mostCurrent._txthargaitem.SetLayout(anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (10)),(int) (mostCurrent._txtnamaitem.getTop()+mostCurrent._txtnamaitem.getHeight()),anywheresoftware.b4a.keywords.Common.PerXToCurrent((float) (95),mostCurrent.activityBA),anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (55)));
RDebugUtils.currentLine=1310734;
 //BA.debugLineNum = 1310734;BA.debugLine="btnKembali.Text = \"Kembali\"";
mostCurrent._btnkembali.setText(BA.ObjectToCharSequence("Kembali"));
RDebugUtils.currentLine=1310735;
 //BA.debugLineNum = 1310735;BA.debugLine="btnKembali.SetLayout(10dip, txtHargaitem.Top + tx";
mostCurrent._btnkembali.SetLayout(anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (10)),(int) (mostCurrent._txthargaitem.getTop()+mostCurrent._txthargaitem.getHeight()),anywheresoftware.b4a.keywords.Common.PerXToCurrent((float) (35),mostCurrent.activityBA),anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (55)));
RDebugUtils.currentLine=1310737;
 //BA.debugLineNum = 1310737;BA.debugLine="btnSimpan.Text = \"Simpan\"";
mostCurrent._btnsimpan.setText(BA.ObjectToCharSequence("Simpan"));
RDebugUtils.currentLine=1310738;
 //BA.debugLineNum = 1310738;BA.debugLine="btnSimpan.SetLayout(btnKembali.Left + btnKembali.";
mostCurrent._btnsimpan.SetLayout((int) (mostCurrent._btnkembali.getLeft()+mostCurrent._btnkembali.getWidth()),(int) (mostCurrent._txthargaitem.getTop()+mostCurrent._txthargaitem.getHeight()),anywheresoftware.b4a.keywords.Common.PerXToCurrent((float) (35),mostCurrent.activityBA),anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (55)));
RDebugUtils.currentLine=1310739;
 //BA.debugLineNum = 1310739;BA.debugLine="End Sub";
return "";
}
public static String  _activity_pause(boolean _userclosed) throws Exception{
RDebugUtils.currentModule="atambah";
RDebugUtils.currentLine=1441792;
 //BA.debugLineNum = 1441792;BA.debugLine="Sub Activity_Pause (UserClosed As Boolean)";
RDebugUtils.currentLine=1441794;
 //BA.debugLineNum = 1441794;BA.debugLine="End Sub";
return "";
}
public static String  _activity_resume() throws Exception{
RDebugUtils.currentModule="atambah";
if (Debug.shouldDelegate(mostCurrent.activityBA, "activity_resume", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "activity_resume", null));}
RDebugUtils.currentLine=1376256;
 //BA.debugLineNum = 1376256;BA.debugLine="Sub Activity_Resume";
RDebugUtils.currentLine=1376258;
 //BA.debugLineNum = 1376258;BA.debugLine="End Sub";
return "";
}
public static String  _btnkembali_click() throws Exception{
RDebugUtils.currentModule="atambah";
if (Debug.shouldDelegate(mostCurrent.activityBA, "btnkembali_click", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "btnkembali_click", null));}
RDebugUtils.currentLine=24838144;
 //BA.debugLineNum = 24838144;BA.debugLine="Private Sub btnKembali_Click";
RDebugUtils.currentLine=24838145;
 //BA.debugLineNum = 24838145;BA.debugLine="StartActivity(aLIST)";
anywheresoftware.b4a.keywords.Common.StartActivity(processBA,(Object)(mostCurrent._alist.getObject()));
RDebugUtils.currentLine=24838146;
 //BA.debugLineNum = 24838146;BA.debugLine="End Sub";
return "";
}
public static void  _btnsimpan_click() throws Exception{
RDebugUtils.currentModule="atambah";
if (Debug.shouldDelegate(mostCurrent.activityBA, "btnsimpan_click", false))
	 {Debug.delegate(mostCurrent.activityBA, "btnsimpan_click", null); return;}
ResumableSub_btnSimpan_Click rsub = new ResumableSub_btnSimpan_Click(null);
rsub.resume(processBA, null);
}
public static class ResumableSub_btnSimpan_Click extends BA.ResumableSub {
public ResumableSub_btnSimpan_Click(b4a.example.atambah parent) {
this.parent = parent;
}
b4a.example.atambah parent;
int _result = 0;
anywheresoftware.b4a.objects.collections.Map _nv = null;
b4a.example.httpjob _j = null;

@Override
public void resume(BA ba, Object[] result) throws Exception{
RDebugUtils.currentModule="atambah";

    while (true) {
try {

        switch (state) {
            case -1:
return;

case 0:
//C
this.state = 1;
RDebugUtils.currentLine=24772609;
 //BA.debugLineNum = 24772609;BA.debugLine="Msgbox2Async(\"Simpan data sekarang.\", \"KONFIRMASI";
anywheresoftware.b4a.keywords.Common.Msgbox2Async(BA.ObjectToCharSequence("Simpan data sekarang."),BA.ObjectToCharSequence("KONFIRMASI"),"Ya","Tidak","",(anywheresoftware.b4a.objects.drawable.CanvasWrapper.BitmapWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.objects.drawable.CanvasWrapper.BitmapWrapper(), (android.graphics.Bitmap)(anywheresoftware.b4a.keywords.Common.Null)),processBA,anywheresoftware.b4a.keywords.Common.True);
RDebugUtils.currentLine=24772610;
 //BA.debugLineNum = 24772610;BA.debugLine="Wait For Msgbox_Result(Result As Int)";
anywheresoftware.b4a.keywords.Common.WaitFor("msgbox_result", processBA, new anywheresoftware.b4a.shell.DebugResumableSub.DelegatableResumableSub(this, "atambah", "btnsimpan_click"), null);
this.state = 21;
return;
case 21:
//C
this.state = 1;
_result = (Integer) result[0];
;
RDebugUtils.currentLine=24772611;
 //BA.debugLineNum = 24772611;BA.debugLine="If Result = DialogResponse.POSITIVE Then";
if (true) break;

case 1:
//if
this.state = 20;
if (_result==anywheresoftware.b4a.keywords.Common.DialogResponse.POSITIVE) { 
this.state = 3;
}if (true) break;

case 3:
//C
this.state = 4;
RDebugUtils.currentLine=24772613;
 //BA.debugLineNum = 24772613;BA.debugLine="Try";
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
RDebugUtils.currentLine=24772614;
 //BA.debugLineNum = 24772614;BA.debugLine="ProgressDialogShow(\"Proses..\")";
anywheresoftware.b4a.keywords.Common.ProgressDialogShow(mostCurrent.activityBA,BA.ObjectToCharSequence("Proses.."));
RDebugUtils.currentLine=24772615;
 //BA.debugLineNum = 24772615;BA.debugLine="Dim NV As Map";
_nv = new anywheresoftware.b4a.objects.collections.Map();
RDebugUtils.currentLine=24772616;
 //BA.debugLineNum = 24772616;BA.debugLine="Dim j As HttpJob";
_j = new b4a.example.httpjob();
RDebugUtils.currentLine=24772618;
 //BA.debugLineNum = 24772618;BA.debugLine="j.Initialize(\"\", Me)";
_j._initialize /*String*/ (null,processBA,"",atambah.getObject());
RDebugUtils.currentLine=24772619;
 //BA.debugLineNum = 24772619;BA.debugLine="NV.Initialize";
_nv.Initialize();
RDebugUtils.currentLine=24772620;
 //BA.debugLineNum = 24772620;BA.debugLine="NV.Put(\"kodeitem\", txtKodeitem.Text)";
_nv.Put((Object)("kodeitem"),(Object)(parent.mostCurrent._txtkodeitem.getText()));
RDebugUtils.currentLine=24772621;
 //BA.debugLineNum = 24772621;BA.debugLine="NV.Put(\"namaitem\", txtNamaitem.Text)";
_nv.Put((Object)("namaitem"),(Object)(parent.mostCurrent._txtnamaitem.getText()));
RDebugUtils.currentLine=24772622;
 //BA.debugLineNum = 24772622;BA.debugLine="NV.Put(\"hargaitem\", txtHargaitem.Text)";
_nv.Put((Object)("hargaitem"),(Object)(parent.mostCurrent._txthargaitem.getText()));
RDebugUtils.currentLine=24772623;
 //BA.debugLineNum = 24772623;BA.debugLine="j.PostMultipart(\"http://192.168.102.50/b4a_ws/i";
_j._postmultipart /*String*/ (null,"http://192.168.102.50/b4a_ws/insert.php",_nv,(anywheresoftware.b4a.objects.collections.List) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.objects.collections.List(), (java.util.List)(anywheresoftware.b4a.keywords.Common.Null)));
RDebugUtils.currentLine=24772624;
 //BA.debugLineNum = 24772624;BA.debugLine="Wait For (j) JobDone(j As HttpJob)";
anywheresoftware.b4a.keywords.Common.WaitFor("jobdone", processBA, new anywheresoftware.b4a.shell.DebugResumableSub.DelegatableResumableSub(this, "atambah", "btnsimpan_click"), (Object)(_j));
this.state = 22;
return;
case 22:
//C
this.state = 7;
_j = (b4a.example.httpjob) result[0];
;
RDebugUtils.currentLine=24772625;
 //BA.debugLineNum = 24772625;BA.debugLine="If j.Success Then";
if (true) break;

case 7:
//if
this.state = 16;
if (_j._success /*boolean*/ ) { 
this.state = 9;
}if (true) break;

case 9:
//C
this.state = 10;
RDebugUtils.currentLine=24772627;
 //BA.debugLineNum = 24772627;BA.debugLine="ProgressDialogHide";
anywheresoftware.b4a.keywords.Common.ProgressDialogHide();
RDebugUtils.currentLine=24772628;
 //BA.debugLineNum = 24772628;BA.debugLine="Log(j.GetString)";
anywheresoftware.b4a.keywords.Common.LogImpl("124772628",_j._getstring /*String*/ (null),0);
RDebugUtils.currentLine=24772630;
 //BA.debugLineNum = 24772630;BA.debugLine="If j.GetString == \"sukses\" Then";
if (true) break;

case 10:
//if
this.state = 15;
if ((_j._getstring /*String*/ (null)).equals("sukses")) { 
this.state = 12;
}else {
this.state = 14;
}if (true) break;

case 12:
//C
this.state = 15;
RDebugUtils.currentLine=24772631;
 //BA.debugLineNum = 24772631;BA.debugLine="txtKodeitem.Text = \"\"";
parent.mostCurrent._txtkodeitem.setText((Object)(""));
RDebugUtils.currentLine=24772632;
 //BA.debugLineNum = 24772632;BA.debugLine="txtNamaitem.Text = \"\"";
parent.mostCurrent._txtnamaitem.setText((Object)(""));
RDebugUtils.currentLine=24772633;
 //BA.debugLineNum = 24772633;BA.debugLine="txtHargaitem.Text = \"\"";
parent.mostCurrent._txthargaitem.setText((Object)(""));
RDebugUtils.currentLine=24772634;
 //BA.debugLineNum = 24772634;BA.debugLine="ToastMessageShow(\"Berhasil tambah data..\", Tr";
anywheresoftware.b4a.keywords.Common.ToastMessageShow(BA.ObjectToCharSequence("Berhasil tambah data.."),anywheresoftware.b4a.keywords.Common.True);
 if (true) break;

case 14:
//C
this.state = 15;
RDebugUtils.currentLine=24772636;
 //BA.debugLineNum = 24772636;BA.debugLine="ToastMessageShow(j.GetString, True)";
anywheresoftware.b4a.keywords.Common.ToastMessageShow(BA.ObjectToCharSequence(_j._getstring /*String*/ (null)),anywheresoftware.b4a.keywords.Common.True);
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
RDebugUtils.currentLine=24772640;
 //BA.debugLineNum = 24772640;BA.debugLine="j.Release";
_j._release /*String*/ (null);
 if (true) break;

case 18:
//C
this.state = 19;
this.catchState = 0;
RDebugUtils.currentLine=24772642;
 //BA.debugLineNum = 24772642;BA.debugLine="ToastMessageShow(LastException, True)";
anywheresoftware.b4a.keywords.Common.ToastMessageShow(BA.ObjectToCharSequence(anywheresoftware.b4a.keywords.Common.LastException(mostCurrent.activityBA).getObject()),anywheresoftware.b4a.keywords.Common.True);
RDebugUtils.currentLine=24772643;
 //BA.debugLineNum = 24772643;BA.debugLine="Log(LastException)";
anywheresoftware.b4a.keywords.Common.LogImpl("124772643",BA.ObjectToString(anywheresoftware.b4a.keywords.Common.LastException(mostCurrent.activityBA)),0);
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
RDebugUtils.currentLine=24772647;
 //BA.debugLineNum = 24772647;BA.debugLine="End Sub";
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
}