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

public class aedit extends Activity implements B4AActivity{
	public static aedit mostCurrent;
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
			processBA = new anywheresoftware.b4a.ShellBA(this.getApplicationContext(), null, null, "b4a.example", "b4a.example.aedit");
			processBA.loadHtSubs(this.getClass());
	        float deviceScale = getApplicationContext().getResources().getDisplayMetrics().density;
	        BALayout.setDeviceScale(deviceScale);
            
		}
		else if (previousOne != null) {
			Activity p = previousOne.get();
			if (p != null && p != this) {
                BA.LogInfo("Killing previous instance (aedit).");
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
		activityBA = new BA(this, layout, processBA, "b4a.example", "b4a.example.aedit");
        
        processBA.sharedProcessBA.activityBA = new java.lang.ref.WeakReference<BA>(activityBA);
        anywheresoftware.b4a.objects.ViewWrapper.lastId = 0;
        _activity = new ActivityWrapper(activityBA, "activity");
        anywheresoftware.b4a.Msgbox.isDismissing = false;
        if (BA.isShellModeRuntimeCheck(processBA)) {
			if (isFirst)
				processBA.raiseEvent2(null, true, "SHELL", false);
			processBA.raiseEvent2(null, true, "CREATE", true, "b4a.example.aedit", processBA, activityBA, _activity, anywheresoftware.b4a.keywords.Common.Density, mostCurrent);
			_activity.reinitializeForShell(activityBA, "activity");
		}
        initializeProcessGlobals();		
        initializeGlobals();
        
        BA.LogInfo("** Activity (aedit) Create, isFirst = " + isFirst + " **");
        processBA.raiseEvent2(null, true, "activity_create", false, isFirst);
		isFirst = false;
		if (this != mostCurrent)
			return;
        processBA.setActivityPaused(false);
        BA.LogInfo("** Activity (aedit) Resume **");
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
		return aedit.class;
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
            BA.LogInfo("** Activity (aedit) Pause, UserClosed = " + activityBA.activity.isFinishing() + " **");
        else
            BA.LogInfo("** Activity (aedit) Pause event (activity is not paused). **");
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
            aedit mc = mostCurrent;
			if (mc == null || mc != activity.get())
				return;
			processBA.setActivityPaused(false);
            BA.LogInfo("** Activity (aedit) Resume **");
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
public static String _kodeitem = "";
public anywheresoftware.b4a.objects.FloatLabeledEditTextWrapper _txtkodeitem = null;
public anywheresoftware.b4a.objects.FloatLabeledEditTextWrapper _txtnamaitem = null;
public anywheresoftware.b4a.objects.FloatLabeledEditTextWrapper _txthargaitem = null;
public anywheresoftware.b4a.objects.ButtonWrapper _btnkembali = null;
public anywheresoftware.b4a.objects.ButtonWrapper _btnsimpan = null;
public anywheresoftware.b4a.objects.ButtonWrapper _btnhapus = null;
public b4a.example.main _main = null;
public b4a.example.starter _starter = null;
public b4a.example.alist _alist = null;
public b4a.example.atambah _atambah = null;
public b4a.example.multipartpost _multipartpost = null;
public b4a.example.httputils2service _httputils2service = null;
public static void  _activity_create(boolean _firsttime) throws Exception{
RDebugUtils.currentModule="aedit";
if (Debug.shouldDelegate(mostCurrent.activityBA, "activity_create", false))
	 {Debug.delegate(mostCurrent.activityBA, "activity_create", new Object[] {_firsttime}); return;}
ResumableSub_Activity_Create rsub = new ResumableSub_Activity_Create(null,_firsttime);
rsub.resume(processBA, null);
}
public static class ResumableSub_Activity_Create extends BA.ResumableSub {
public ResumableSub_Activity_Create(b4a.example.aedit parent,boolean _firsttime) {
this.parent = parent;
this._firsttime = _firsttime;
}
b4a.example.aedit parent;
boolean _firsttime;
int _result = 0;

@Override
public void resume(BA ba, Object[] result) throws Exception{
RDebugUtils.currentModule="aedit";

    while (true) {
        switch (state) {
            case -1:
return;

case 0:
//C
this.state = -1;
RDebugUtils.currentLine=28377089;
 //BA.debugLineNum = 28377089;BA.debugLine="Activity.LoadLayout(\"vEDIT\")";
parent.mostCurrent._activity.LoadLayout("vEDIT",mostCurrent.activityBA);
RDebugUtils.currentLine=28377090;
 //BA.debugLineNum = 28377090;BA.debugLine="Activity.Title = \"Edit Data\"";
parent.mostCurrent._activity.setTitle(BA.ObjectToCharSequence("Edit Data"));
RDebugUtils.currentLine=28377092;
 //BA.debugLineNum = 28377092;BA.debugLine="txtKodeitem.Enabled = False";
parent.mostCurrent._txtkodeitem.setEnabled(anywheresoftware.b4a.keywords.Common.False);
RDebugUtils.currentLine=28377093;
 //BA.debugLineNum = 28377093;BA.debugLine="txtKodeitem.Hint = \"Kodeitem\"";
parent.mostCurrent._txtkodeitem.setHint("Kodeitem");
RDebugUtils.currentLine=28377094;
 //BA.debugLineNum = 28377094;BA.debugLine="txtKodeitem.SetLayout(10dip, 10dip, 95%x, 55dip)";
parent.mostCurrent._txtkodeitem.SetLayout(anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (10)),anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (10)),anywheresoftware.b4a.keywords.Common.PerXToCurrent((float) (95),mostCurrent.activityBA),anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (55)));
RDebugUtils.currentLine=28377096;
 //BA.debugLineNum = 28377096;BA.debugLine="txtNamaitem.Hint = \"Namaitem\"";
parent.mostCurrent._txtnamaitem.setHint("Namaitem");
RDebugUtils.currentLine=28377097;
 //BA.debugLineNum = 28377097;BA.debugLine="txtNamaitem.SetLayout(10dip, txtKodeitem.Top + tx";
parent.mostCurrent._txtnamaitem.SetLayout(anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (10)),(int) (parent.mostCurrent._txtkodeitem.getTop()+parent.mostCurrent._txtkodeitem.getHeight()),anywheresoftware.b4a.keywords.Common.PerXToCurrent((float) (95),mostCurrent.activityBA),anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (55)));
RDebugUtils.currentLine=28377099;
 //BA.debugLineNum = 28377099;BA.debugLine="txtHargaitem.Hint = \"Hargaitem\"";
parent.mostCurrent._txthargaitem.setHint("Hargaitem");
RDebugUtils.currentLine=28377100;
 //BA.debugLineNum = 28377100;BA.debugLine="txtHargaitem.EditText.InputType = txtHargaitem.Ed";
parent.mostCurrent._txthargaitem.getEditText().setInputType(parent.mostCurrent._txthargaitem.getEditText().INPUT_TYPE_NUMBERS);
RDebugUtils.currentLine=28377101;
 //BA.debugLineNum = 28377101;BA.debugLine="txtHargaitem.SetLayout(10dip, txtNamaitem.Top + t";
parent.mostCurrent._txthargaitem.SetLayout(anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (10)),(int) (parent.mostCurrent._txtnamaitem.getTop()+parent.mostCurrent._txtnamaitem.getHeight()),anywheresoftware.b4a.keywords.Common.PerXToCurrent((float) (95),mostCurrent.activityBA),anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (55)));
RDebugUtils.currentLine=28377103;
 //BA.debugLineNum = 28377103;BA.debugLine="btnKembali.Text = \"Kembali\"";
parent.mostCurrent._btnkembali.setText(BA.ObjectToCharSequence("Kembali"));
RDebugUtils.currentLine=28377104;
 //BA.debugLineNum = 28377104;BA.debugLine="btnKembali.SetLayout(10dip, txtHargaitem.Top + tx";
parent.mostCurrent._btnkembali.SetLayout(anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (10)),(int) (parent.mostCurrent._txthargaitem.getTop()+parent.mostCurrent._txthargaitem.getHeight()),anywheresoftware.b4a.keywords.Common.PerXToCurrent((float) (25),mostCurrent.activityBA),anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (55)));
RDebugUtils.currentLine=28377106;
 //BA.debugLineNum = 28377106;BA.debugLine="btnHapus.Text = \"Hapus\"";
parent.mostCurrent._btnhapus.setText(BA.ObjectToCharSequence("Hapus"));
RDebugUtils.currentLine=28377107;
 //BA.debugLineNum = 28377107;BA.debugLine="btnHapus.Color = Colors.Red";
parent.mostCurrent._btnhapus.setColor(anywheresoftware.b4a.keywords.Common.Colors.Red);
RDebugUtils.currentLine=28377108;
 //BA.debugLineNum = 28377108;BA.debugLine="btnHapus.TextColor = Colors.White";
parent.mostCurrent._btnhapus.setTextColor(anywheresoftware.b4a.keywords.Common.Colors.White);
RDebugUtils.currentLine=28377109;
 //BA.debugLineNum = 28377109;BA.debugLine="btnHapus.SetLayout(btnKembali.Left + btnKembali.W";
parent.mostCurrent._btnhapus.SetLayout((int) (parent.mostCurrent._btnkembali.getLeft()+parent.mostCurrent._btnkembali.getWidth()),(int) (parent.mostCurrent._txthargaitem.getTop()+parent.mostCurrent._txthargaitem.getHeight()),anywheresoftware.b4a.keywords.Common.PerXToCurrent((float) (25),mostCurrent.activityBA),anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (55)));
RDebugUtils.currentLine=28377111;
 //BA.debugLineNum = 28377111;BA.debugLine="btnSimpan.Text = \"Simpan\"";
parent.mostCurrent._btnsimpan.setText(BA.ObjectToCharSequence("Simpan"));
RDebugUtils.currentLine=28377112;
 //BA.debugLineNum = 28377112;BA.debugLine="btnSimpan.SetLayout(btnHapus.Left + btnHapus.Widt";
parent.mostCurrent._btnsimpan.SetLayout((int) (parent.mostCurrent._btnhapus.getLeft()+parent.mostCurrent._btnhapus.getWidth()),(int) (parent.mostCurrent._txthargaitem.getTop()+parent.mostCurrent._txthargaitem.getHeight()),anywheresoftware.b4a.keywords.Common.PerXToCurrent((float) (25),mostCurrent.activityBA),anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (55)));
RDebugUtils.currentLine=28377114;
 //BA.debugLineNum = 28377114;BA.debugLine="ProgressDialogShow(\"Loading..\")";
anywheresoftware.b4a.keywords.Common.ProgressDialogShow(mostCurrent.activityBA,BA.ObjectToCharSequence("Loading.."));
RDebugUtils.currentLine=28377115;
 //BA.debugLineNum = 28377115;BA.debugLine="Wait For(detaildata) Complete (Result As Int)";
anywheresoftware.b4a.keywords.Common.WaitFor("complete", processBA, new anywheresoftware.b4a.shell.DebugResumableSub.DelegatableResumableSub(this, "aedit", "activity_create"), _detaildata());
this.state = 1;
return;
case 1:
//C
this.state = -1;
_result = (Integer) result[0];
;
RDebugUtils.currentLine=28377116;
 //BA.debugLineNum = 28377116;BA.debugLine="ProgressDialogHide";
anywheresoftware.b4a.keywords.Common.ProgressDialogHide();
RDebugUtils.currentLine=28377117;
 //BA.debugLineNum = 28377117;BA.debugLine="End Sub";
if (true) break;

            }
        }
    }
}
public static anywheresoftware.b4a.keywords.Common.ResumableSubWrapper  _detaildata() throws Exception{
RDebugUtils.currentModule="aedit";
if (Debug.shouldDelegate(mostCurrent.activityBA, "detaildata", false))
	 {return ((anywheresoftware.b4a.keywords.Common.ResumableSubWrapper) Debug.delegate(mostCurrent.activityBA, "detaildata", null));}
ResumableSub_detaildata rsub = new ResumableSub_detaildata(null);
rsub.resume(processBA, null);
return (anywheresoftware.b4a.keywords.Common.ResumableSubWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.keywords.Common.ResumableSubWrapper(), rsub);
}
public static class ResumableSub_detaildata extends BA.ResumableSub {
public ResumableSub_detaildata(b4a.example.aedit parent) {
this.parent = parent;
}
b4a.example.aedit parent;
anywheresoftware.b4a.objects.collections.Map _nv = null;
b4a.example.httpjob _j = null;
anywheresoftware.b4a.objects.collections.JSONParser _jp = null;
anywheresoftware.b4a.objects.collections.List _rows = null;
anywheresoftware.b4a.objects.collections.Map _row = null;
anywheresoftware.b4a.BA.IterableList group20;
int index20;
int groupLen20;

@Override
public void resume(BA ba, Object[] result) throws Exception{
RDebugUtils.currentModule="aedit";

    while (true) {
try {

        switch (state) {
            case -1:
{
anywheresoftware.b4a.keywords.Common.ReturnFromResumableSub(this,null);return;}
case 0:
//C
this.state = 1;
RDebugUtils.currentLine=29425666;
 //BA.debugLineNum = 29425666;BA.debugLine="Try";
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
RDebugUtils.currentLine=29425667;
 //BA.debugLineNum = 29425667;BA.debugLine="ProgressDialogShow(\"Proses..\")";
anywheresoftware.b4a.keywords.Common.ProgressDialogShow(mostCurrent.activityBA,BA.ObjectToCharSequence("Proses.."));
RDebugUtils.currentLine=29425668;
 //BA.debugLineNum = 29425668;BA.debugLine="Dim NV As Map";
_nv = new anywheresoftware.b4a.objects.collections.Map();
RDebugUtils.currentLine=29425669;
 //BA.debugLineNum = 29425669;BA.debugLine="Dim j As HttpJob";
_j = new b4a.example.httpjob();
RDebugUtils.currentLine=29425671;
 //BA.debugLineNum = 29425671;BA.debugLine="j.Initialize(\"\", Me)";
_j._initialize /*String*/ (null,processBA,"",aedit.getObject());
RDebugUtils.currentLine=29425672;
 //BA.debugLineNum = 29425672;BA.debugLine="NV.Initialize";
_nv.Initialize();
RDebugUtils.currentLine=29425673;
 //BA.debugLineNum = 29425673;BA.debugLine="NV.Put(\"kodeitem\", kodeitem)";
_nv.Put((Object)("kodeitem"),(Object)(parent._kodeitem));
RDebugUtils.currentLine=29425674;
 //BA.debugLineNum = 29425674;BA.debugLine="j.PostMultipart(\"http://192.168.102.50/b4a_ws/de";
_j._postmultipart /*String*/ (null,"http://192.168.102.50/b4a_ws/detail.php",_nv,(anywheresoftware.b4a.objects.collections.List) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.objects.collections.List(), (java.util.List)(anywheresoftware.b4a.keywords.Common.Null)));
RDebugUtils.currentLine=29425675;
 //BA.debugLineNum = 29425675;BA.debugLine="Wait For (j) JobDone(j As HttpJob)";
anywheresoftware.b4a.keywords.Common.WaitFor("jobdone", processBA, new anywheresoftware.b4a.shell.DebugResumableSub.DelegatableResumableSub(this, "aedit", "detaildata"), (Object)(_j));
this.state = 19;
return;
case 19:
//C
this.state = 4;
_j = (b4a.example.httpjob) result[0];
;
RDebugUtils.currentLine=29425676;
 //BA.debugLineNum = 29425676;BA.debugLine="If j.Success Then";
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
RDebugUtils.currentLine=29425678;
 //BA.debugLineNum = 29425678;BA.debugLine="ProgressDialogHide";
anywheresoftware.b4a.keywords.Common.ProgressDialogHide();
RDebugUtils.currentLine=29425680;
 //BA.debugLineNum = 29425680;BA.debugLine="Log(j.GetString)";
anywheresoftware.b4a.keywords.Common.LogImpl("129425680",_j._getstring /*String*/ (null),0);
RDebugUtils.currentLine=29425681;
 //BA.debugLineNum = 29425681;BA.debugLine="If j.GetString = Null Or j.GetString = \"[]\" The";
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
RDebugUtils.currentLine=29425682;
 //BA.debugLineNum = 29425682;BA.debugLine="ToastMessageShow(\"Tidak ada data yang ditampil";
anywheresoftware.b4a.keywords.Common.ToastMessageShow(BA.ObjectToCharSequence("Tidak ada data yang ditampilkan"),anywheresoftware.b4a.keywords.Common.False);
RDebugUtils.currentLine=29425683;
 //BA.debugLineNum = 29425683;BA.debugLine="Return 0";
if (true) {
anywheresoftware.b4a.keywords.Common.ReturnFromResumableSub(this,(Object)(0));return;};
 if (true) break;

case 10:
//C
this.state = 11;
;
RDebugUtils.currentLine=29425686;
 //BA.debugLineNum = 29425686;BA.debugLine="Dim jp As JSONParser";
_jp = new anywheresoftware.b4a.objects.collections.JSONParser();
RDebugUtils.currentLine=29425687;
 //BA.debugLineNum = 29425687;BA.debugLine="jp.Initialize(j.GetString)";
_jp.Initialize(_j._getstring /*String*/ (null));
RDebugUtils.currentLine=29425688;
 //BA.debugLineNum = 29425688;BA.debugLine="Dim rows As List = jp.NextArray";
_rows = new anywheresoftware.b4a.objects.collections.List();
_rows = _jp.NextArray();
RDebugUtils.currentLine=29425691;
 //BA.debugLineNum = 29425691;BA.debugLine="For Each row As Map In rows";
if (true) break;

case 11:
//for
this.state = 14;
_row = new anywheresoftware.b4a.objects.collections.Map();
group20 = _rows;
index20 = 0;
groupLen20 = group20.getSize();
this.state = 20;
if (true) break;

case 20:
//C
this.state = 14;
if (index20 < groupLen20) {
this.state = 13;
_row = (anywheresoftware.b4a.objects.collections.Map) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.objects.collections.Map(), (anywheresoftware.b4a.objects.collections.Map.MyMap)(group20.Get(index20)));}
if (true) break;

case 21:
//C
this.state = 20;
index20++;
if (true) break;

case 13:
//C
this.state = 21;
RDebugUtils.currentLine=29425693;
 //BA.debugLineNum = 29425693;BA.debugLine="txtKodeitem.Text = row.Get(\"kodeitem\")";
parent.mostCurrent._txtkodeitem.setText(_row.Get((Object)("kodeitem")));
RDebugUtils.currentLine=29425694;
 //BA.debugLineNum = 29425694;BA.debugLine="txtNamaitem.Text = row.Get(\"namaitem\")";
parent.mostCurrent._txtnamaitem.setText(_row.Get((Object)("namaitem")));
RDebugUtils.currentLine=29425695;
 //BA.debugLineNum = 29425695;BA.debugLine="txtHargaitem.Text = row.Get(\"hargaitem\")";
parent.mostCurrent._txthargaitem.setText(_row.Get((Object)("hargaitem")));
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
RDebugUtils.currentLine=29425700;
 //BA.debugLineNum = 29425700;BA.debugLine="j.Release";
_j._release /*String*/ (null);
RDebugUtils.currentLine=29425702;
 //BA.debugLineNum = 29425702;BA.debugLine="Log(\"Selesai Load\")";
anywheresoftware.b4a.keywords.Common.LogImpl("129425702","Selesai Load",0);
 if (true) break;

case 17:
//C
this.state = 18;
this.catchState = 0;
RDebugUtils.currentLine=29425706;
 //BA.debugLineNum = 29425706;BA.debugLine="ProgressDialogHide";
anywheresoftware.b4a.keywords.Common.ProgressDialogHide();
RDebugUtils.currentLine=29425707;
 //BA.debugLineNum = 29425707;BA.debugLine="ToastMessageShow(LastException, True)";
anywheresoftware.b4a.keywords.Common.ToastMessageShow(BA.ObjectToCharSequence(anywheresoftware.b4a.keywords.Common.LastException(mostCurrent.activityBA).getObject()),anywheresoftware.b4a.keywords.Common.True);
RDebugUtils.currentLine=29425708;
 //BA.debugLineNum = 29425708;BA.debugLine="Log(LastException)";
anywheresoftware.b4a.keywords.Common.LogImpl("129425708",BA.ObjectToString(anywheresoftware.b4a.keywords.Common.LastException(mostCurrent.activityBA)),0);
 if (true) break;
if (true) break;

case 18:
//C
this.state = -1;
this.catchState = 0;
;
RDebugUtils.currentLine=29425711;
 //BA.debugLineNum = 29425711;BA.debugLine="Return 0";
if (true) {
anywheresoftware.b4a.keywords.Common.ReturnFromResumableSub(this,(Object)(0));return;};
RDebugUtils.currentLine=29425713;
 //BA.debugLineNum = 29425713;BA.debugLine="End Sub";
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
RDebugUtils.currentModule="aedit";
RDebugUtils.currentLine=28508160;
 //BA.debugLineNum = 28508160;BA.debugLine="Sub Activity_Pause (UserClosed As Boolean)";
RDebugUtils.currentLine=28508162;
 //BA.debugLineNum = 28508162;BA.debugLine="End Sub";
return "";
}
public static String  _activity_resume() throws Exception{
RDebugUtils.currentModule="aedit";
if (Debug.shouldDelegate(mostCurrent.activityBA, "activity_resume", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "activity_resume", null));}
RDebugUtils.currentLine=28442624;
 //BA.debugLineNum = 28442624;BA.debugLine="Sub Activity_Resume";
RDebugUtils.currentLine=28442626;
 //BA.debugLineNum = 28442626;BA.debugLine="End Sub";
return "";
}
public static void  _btnhapus_click() throws Exception{
RDebugUtils.currentModule="aedit";
if (Debug.shouldDelegate(mostCurrent.activityBA, "btnhapus_click", false))
	 {Debug.delegate(mostCurrent.activityBA, "btnhapus_click", null); return;}
ResumableSub_btnHapus_Click rsub = new ResumableSub_btnHapus_Click(null);
rsub.resume(processBA, null);
}
public static class ResumableSub_btnHapus_Click extends BA.ResumableSub {
public ResumableSub_btnHapus_Click(b4a.example.aedit parent) {
this.parent = parent;
}
b4a.example.aedit parent;
int _result = 0;
anywheresoftware.b4a.objects.collections.Map _nv = null;
b4a.example.httpjob _j = null;

@Override
public void resume(BA ba, Object[] result) throws Exception{
RDebugUtils.currentModule="aedit";

    while (true) {
try {

        switch (state) {
            case -1:
return;

case 0:
//C
this.state = 1;
RDebugUtils.currentLine=28704769;
 //BA.debugLineNum = 28704769;BA.debugLine="Msgbox2Async(\"Hapus data ini ?.\", \"KONFIRMASI\", \"";
anywheresoftware.b4a.keywords.Common.Msgbox2Async(BA.ObjectToCharSequence("Hapus data ini ?."),BA.ObjectToCharSequence("KONFIRMASI"),"Ya","Tidak","",(anywheresoftware.b4a.objects.drawable.CanvasWrapper.BitmapWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.objects.drawable.CanvasWrapper.BitmapWrapper(), (android.graphics.Bitmap)(anywheresoftware.b4a.keywords.Common.Null)),processBA,anywheresoftware.b4a.keywords.Common.True);
RDebugUtils.currentLine=28704770;
 //BA.debugLineNum = 28704770;BA.debugLine="Wait For Msgbox_Result(Result As Int)";
anywheresoftware.b4a.keywords.Common.WaitFor("msgbox_result", processBA, new anywheresoftware.b4a.shell.DebugResumableSub.DelegatableResumableSub(this, "aedit", "btnhapus_click"), null);
this.state = 21;
return;
case 21:
//C
this.state = 1;
_result = (Integer) result[0];
;
RDebugUtils.currentLine=28704771;
 //BA.debugLineNum = 28704771;BA.debugLine="If Result = DialogResponse.POSITIVE Then";
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
RDebugUtils.currentLine=28704773;
 //BA.debugLineNum = 28704773;BA.debugLine="Try";
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
RDebugUtils.currentLine=28704774;
 //BA.debugLineNum = 28704774;BA.debugLine="ProgressDialogShow(\"Proses..\")";
anywheresoftware.b4a.keywords.Common.ProgressDialogShow(mostCurrent.activityBA,BA.ObjectToCharSequence("Proses.."));
RDebugUtils.currentLine=28704775;
 //BA.debugLineNum = 28704775;BA.debugLine="Dim NV As Map";
_nv = new anywheresoftware.b4a.objects.collections.Map();
RDebugUtils.currentLine=28704776;
 //BA.debugLineNum = 28704776;BA.debugLine="Dim j As HttpJob";
_j = new b4a.example.httpjob();
RDebugUtils.currentLine=28704778;
 //BA.debugLineNum = 28704778;BA.debugLine="j.Initialize(\"\", Me)";
_j._initialize /*String*/ (null,processBA,"",aedit.getObject());
RDebugUtils.currentLine=28704779;
 //BA.debugLineNum = 28704779;BA.debugLine="NV.Initialize";
_nv.Initialize();
RDebugUtils.currentLine=28704780;
 //BA.debugLineNum = 28704780;BA.debugLine="NV.Put(\"kodeitem\", kodeitem)";
_nv.Put((Object)("kodeitem"),(Object)(parent._kodeitem));
RDebugUtils.currentLine=28704781;
 //BA.debugLineNum = 28704781;BA.debugLine="j.PostMultipart(\"http://192.168.102.50/b4a_ws/d";
_j._postmultipart /*String*/ (null,"http://192.168.102.50/b4a_ws/delete.php",_nv,(anywheresoftware.b4a.objects.collections.List) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.objects.collections.List(), (java.util.List)(anywheresoftware.b4a.keywords.Common.Null)));
RDebugUtils.currentLine=28704782;
 //BA.debugLineNum = 28704782;BA.debugLine="Wait For (j) JobDone(j As HttpJob)";
anywheresoftware.b4a.keywords.Common.WaitFor("jobdone", processBA, new anywheresoftware.b4a.shell.DebugResumableSub.DelegatableResumableSub(this, "aedit", "btnhapus_click"), (Object)(_j));
this.state = 22;
return;
case 22:
//C
this.state = 7;
_j = (b4a.example.httpjob) result[0];
;
RDebugUtils.currentLine=28704783;
 //BA.debugLineNum = 28704783;BA.debugLine="If j.Success Then";
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
RDebugUtils.currentLine=28704785;
 //BA.debugLineNum = 28704785;BA.debugLine="ProgressDialogHide";
anywheresoftware.b4a.keywords.Common.ProgressDialogHide();
RDebugUtils.currentLine=28704786;
 //BA.debugLineNum = 28704786;BA.debugLine="Log(j.GetString)";
anywheresoftware.b4a.keywords.Common.LogImpl("128704786",_j._getstring /*String*/ (null),0);
RDebugUtils.currentLine=28704788;
 //BA.debugLineNum = 28704788;BA.debugLine="If j.GetString == \"sukses\" Then";
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
RDebugUtils.currentLine=28704789;
 //BA.debugLineNum = 28704789;BA.debugLine="StartActivity(aLIST)";
anywheresoftware.b4a.keywords.Common.StartActivity(processBA,(Object)(parent.mostCurrent._alist.getObject()));
RDebugUtils.currentLine=28704790;
 //BA.debugLineNum = 28704790;BA.debugLine="Activity.Finish";
parent.mostCurrent._activity.Finish();
 if (true) break;

case 14:
//C
this.state = 15;
RDebugUtils.currentLine=28704792;
 //BA.debugLineNum = 28704792;BA.debugLine="ToastMessageShow(j.GetString, True)";
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
RDebugUtils.currentLine=28704796;
 //BA.debugLineNum = 28704796;BA.debugLine="j.Release";
_j._release /*String*/ (null);
 if (true) break;

case 18:
//C
this.state = 19;
this.catchState = 0;
RDebugUtils.currentLine=28704798;
 //BA.debugLineNum = 28704798;BA.debugLine="ToastMessageShow(LastException, True)";
anywheresoftware.b4a.keywords.Common.ToastMessageShow(BA.ObjectToCharSequence(anywheresoftware.b4a.keywords.Common.LastException(mostCurrent.activityBA).getObject()),anywheresoftware.b4a.keywords.Common.True);
RDebugUtils.currentLine=28704799;
 //BA.debugLineNum = 28704799;BA.debugLine="Log(LastException)";
anywheresoftware.b4a.keywords.Common.LogImpl("128704799",BA.ObjectToString(anywheresoftware.b4a.keywords.Common.LastException(mostCurrent.activityBA)),0);
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
RDebugUtils.currentLine=28704803;
 //BA.debugLineNum = 28704803;BA.debugLine="End Sub";
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
public static String  _btnkembali_click() throws Exception{
RDebugUtils.currentModule="aedit";
if (Debug.shouldDelegate(mostCurrent.activityBA, "btnkembali_click", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "btnkembali_click", null));}
RDebugUtils.currentLine=28639232;
 //BA.debugLineNum = 28639232;BA.debugLine="Private Sub btnKembali_Click";
RDebugUtils.currentLine=28639233;
 //BA.debugLineNum = 28639233;BA.debugLine="StartActivity(aLIST)";
anywheresoftware.b4a.keywords.Common.StartActivity(processBA,(Object)(mostCurrent._alist.getObject()));
RDebugUtils.currentLine=28639234;
 //BA.debugLineNum = 28639234;BA.debugLine="End Sub";
return "";
}
public static void  _btnsimpan_click() throws Exception{
RDebugUtils.currentModule="aedit";
if (Debug.shouldDelegate(mostCurrent.activityBA, "btnsimpan_click", false))
	 {Debug.delegate(mostCurrent.activityBA, "btnsimpan_click", null); return;}
ResumableSub_btnSimpan_Click rsub = new ResumableSub_btnSimpan_Click(null);
rsub.resume(processBA, null);
}
public static class ResumableSub_btnSimpan_Click extends BA.ResumableSub {
public ResumableSub_btnSimpan_Click(b4a.example.aedit parent) {
this.parent = parent;
}
b4a.example.aedit parent;
int _result = 0;
anywheresoftware.b4a.objects.collections.Map _nv = null;
b4a.example.httpjob _j = null;

@Override
public void resume(BA ba, Object[] result) throws Exception{
RDebugUtils.currentModule="aedit";

    while (true) {
try {

        switch (state) {
            case -1:
return;

case 0:
//C
this.state = 1;
RDebugUtils.currentLine=28573697;
 //BA.debugLineNum = 28573697;BA.debugLine="Msgbox2Async(\"Simpan data sekarang.\", \"KONFIRMASI";
anywheresoftware.b4a.keywords.Common.Msgbox2Async(BA.ObjectToCharSequence("Simpan data sekarang."),BA.ObjectToCharSequence("KONFIRMASI"),"Ya","Tidak","",(anywheresoftware.b4a.objects.drawable.CanvasWrapper.BitmapWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.objects.drawable.CanvasWrapper.BitmapWrapper(), (android.graphics.Bitmap)(anywheresoftware.b4a.keywords.Common.Null)),processBA,anywheresoftware.b4a.keywords.Common.True);
RDebugUtils.currentLine=28573698;
 //BA.debugLineNum = 28573698;BA.debugLine="Wait For Msgbox_Result(Result As Int)";
anywheresoftware.b4a.keywords.Common.WaitFor("msgbox_result", processBA, new anywheresoftware.b4a.shell.DebugResumableSub.DelegatableResumableSub(this, "aedit", "btnsimpan_click"), null);
this.state = 21;
return;
case 21:
//C
this.state = 1;
_result = (Integer) result[0];
;
RDebugUtils.currentLine=28573699;
 //BA.debugLineNum = 28573699;BA.debugLine="If Result = DialogResponse.POSITIVE Then";
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
RDebugUtils.currentLine=28573701;
 //BA.debugLineNum = 28573701;BA.debugLine="Try";
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
RDebugUtils.currentLine=28573702;
 //BA.debugLineNum = 28573702;BA.debugLine="ProgressDialogShow(\"Proses..\")";
anywheresoftware.b4a.keywords.Common.ProgressDialogShow(mostCurrent.activityBA,BA.ObjectToCharSequence("Proses.."));
RDebugUtils.currentLine=28573703;
 //BA.debugLineNum = 28573703;BA.debugLine="Dim NV As Map";
_nv = new anywheresoftware.b4a.objects.collections.Map();
RDebugUtils.currentLine=28573704;
 //BA.debugLineNum = 28573704;BA.debugLine="Dim j As HttpJob";
_j = new b4a.example.httpjob();
RDebugUtils.currentLine=28573706;
 //BA.debugLineNum = 28573706;BA.debugLine="j.Initialize(\"\", Me)";
_j._initialize /*String*/ (null,processBA,"",aedit.getObject());
RDebugUtils.currentLine=28573707;
 //BA.debugLineNum = 28573707;BA.debugLine="NV.Initialize";
_nv.Initialize();
RDebugUtils.currentLine=28573708;
 //BA.debugLineNum = 28573708;BA.debugLine="NV.Put(\"kodeitem\", txtKodeitem.Text)";
_nv.Put((Object)("kodeitem"),(Object)(parent.mostCurrent._txtkodeitem.getText()));
RDebugUtils.currentLine=28573709;
 //BA.debugLineNum = 28573709;BA.debugLine="NV.Put(\"namaitem\", txtNamaitem.Text)";
_nv.Put((Object)("namaitem"),(Object)(parent.mostCurrent._txtnamaitem.getText()));
RDebugUtils.currentLine=28573710;
 //BA.debugLineNum = 28573710;BA.debugLine="NV.Put(\"hargaitem\", txtHargaitem.Text)";
_nv.Put((Object)("hargaitem"),(Object)(parent.mostCurrent._txthargaitem.getText()));
RDebugUtils.currentLine=28573711;
 //BA.debugLineNum = 28573711;BA.debugLine="j.PostMultipart(\"http://192.168.102.50/b4a_ws/u";
_j._postmultipart /*String*/ (null,"http://192.168.102.50/b4a_ws/update.php",_nv,(anywheresoftware.b4a.objects.collections.List) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.objects.collections.List(), (java.util.List)(anywheresoftware.b4a.keywords.Common.Null)));
RDebugUtils.currentLine=28573712;
 //BA.debugLineNum = 28573712;BA.debugLine="Wait For (j) JobDone(j As HttpJob)";
anywheresoftware.b4a.keywords.Common.WaitFor("jobdone", processBA, new anywheresoftware.b4a.shell.DebugResumableSub.DelegatableResumableSub(this, "aedit", "btnsimpan_click"), (Object)(_j));
this.state = 22;
return;
case 22:
//C
this.state = 7;
_j = (b4a.example.httpjob) result[0];
;
RDebugUtils.currentLine=28573713;
 //BA.debugLineNum = 28573713;BA.debugLine="If j.Success Then";
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
RDebugUtils.currentLine=28573715;
 //BA.debugLineNum = 28573715;BA.debugLine="ProgressDialogHide";
anywheresoftware.b4a.keywords.Common.ProgressDialogHide();
RDebugUtils.currentLine=28573716;
 //BA.debugLineNum = 28573716;BA.debugLine="Log(j.GetString)";
anywheresoftware.b4a.keywords.Common.LogImpl("128573716",_j._getstring /*String*/ (null),0);
RDebugUtils.currentLine=28573718;
 //BA.debugLineNum = 28573718;BA.debugLine="If j.GetString == \"sukses\" Then";
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
RDebugUtils.currentLine=28573719;
 //BA.debugLineNum = 28573719;BA.debugLine="ToastMessageShow(\"Berhasil update data..\", Tr";
anywheresoftware.b4a.keywords.Common.ToastMessageShow(BA.ObjectToCharSequence("Berhasil update data.."),anywheresoftware.b4a.keywords.Common.True);
 if (true) break;

case 14:
//C
this.state = 15;
RDebugUtils.currentLine=28573721;
 //BA.debugLineNum = 28573721;BA.debugLine="ToastMessageShow(j.GetString, True)";
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
RDebugUtils.currentLine=28573725;
 //BA.debugLineNum = 28573725;BA.debugLine="j.Release";
_j._release /*String*/ (null);
 if (true) break;

case 18:
//C
this.state = 19;
this.catchState = 0;
RDebugUtils.currentLine=28573727;
 //BA.debugLineNum = 28573727;BA.debugLine="ToastMessageShow(LastException, True)";
anywheresoftware.b4a.keywords.Common.ToastMessageShow(BA.ObjectToCharSequence(anywheresoftware.b4a.keywords.Common.LastException(mostCurrent.activityBA).getObject()),anywheresoftware.b4a.keywords.Common.True);
RDebugUtils.currentLine=28573728;
 //BA.debugLineNum = 28573728;BA.debugLine="Log(LastException)";
anywheresoftware.b4a.keywords.Common.LogImpl("128573728",BA.ObjectToString(anywheresoftware.b4a.keywords.Common.LastException(mostCurrent.activityBA)),0);
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
RDebugUtils.currentLine=28573732;
 //BA.debugLineNum = 28573732;BA.debugLine="End Sub";
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