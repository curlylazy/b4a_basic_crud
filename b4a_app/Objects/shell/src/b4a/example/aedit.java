
package b4a.example;

import java.io.IOException;
import anywheresoftware.b4a.BA;
import anywheresoftware.b4a.pc.PCBA;
import anywheresoftware.b4a.pc.RDebug;
import anywheresoftware.b4a.pc.RemoteObject;
import anywheresoftware.b4a.pc.RDebug.IRemote;
import anywheresoftware.b4a.pc.Debug;
import anywheresoftware.b4a.pc.B4XTypes.B4XClass;
import anywheresoftware.b4a.pc.B4XTypes.DeviceClass;

public class aedit implements IRemote{
	public static aedit mostCurrent;
	public static RemoteObject processBA;
    public static boolean processGlobalsRun;
    public static RemoteObject myClass;
    public static RemoteObject remoteMe;
	public aedit() {
		mostCurrent = this;
	}
    public RemoteObject getRemoteMe() {
        return remoteMe;    
    }
    
	public static void main (String[] args) throws Exception {
		new RDebug(args[0], Integer.parseInt(args[1]), Integer.parseInt(args[2]), args[3]);
		RDebug.INSTANCE.waitForTask();

	}
    static {
        anywheresoftware.b4a.pc.RapidSub.moduleToObject.put(new B4XClass("aedit"), "b4a.example.aedit");
	}

public boolean isSingleton() {
		return true;
	}
     public static RemoteObject getObject() {
		return myClass;
	 }

	public RemoteObject activityBA;
	public RemoteObject _activity;
    private PCBA pcBA;

	public PCBA create(Object[] args) throws ClassNotFoundException{
		processBA = (RemoteObject) args[1];
		activityBA = (RemoteObject) args[2];
		_activity = (RemoteObject) args[3];
        anywheresoftware.b4a.keywords.Common.Density = (Float)args[4];
        remoteMe = (RemoteObject) args[5];
		pcBA = new PCBA(this, aedit.class);
        main_subs_0.initializeProcessGlobals();
		return pcBA;
	}
public static RemoteObject __c = RemoteObject.declareNull("anywheresoftware.b4a.keywords.Common");
public static RemoteObject _kodeitem = RemoteObject.createImmutable("");
public static RemoteObject _txtkodeitem = RemoteObject.declareNull("anywheresoftware.b4a.objects.FloatLabeledEditTextWrapper");
public static RemoteObject _txtnamaitem = RemoteObject.declareNull("anywheresoftware.b4a.objects.FloatLabeledEditTextWrapper");
public static RemoteObject _txthargaitem = RemoteObject.declareNull("anywheresoftware.b4a.objects.FloatLabeledEditTextWrapper");
public static RemoteObject _btnkembali = RemoteObject.declareNull("anywheresoftware.b4a.objects.ButtonWrapper");
public static RemoteObject _btnsimpan = RemoteObject.declareNull("anywheresoftware.b4a.objects.ButtonWrapper");
public static RemoteObject _btnhapus = RemoteObject.declareNull("anywheresoftware.b4a.objects.ButtonWrapper");
public static b4a.example.main _main = null;
public static b4a.example.starter _starter = null;
public static b4a.example.alist _alist = null;
public static b4a.example.atambah _atambah = null;
public static b4a.example.multipartpost _multipartpost = null;
public static b4a.example.httputils2service _httputils2service = null;
  public Object[] GetGlobals() {
		return new Object[] {"Activity",aedit.mostCurrent._activity,"aLIST",Debug.moduleToString(b4a.example.alist.class),"aTAMBAH",Debug.moduleToString(b4a.example.atambah.class),"btnHapus",aedit.mostCurrent._btnhapus,"btnKembali",aedit.mostCurrent._btnkembali,"btnSimpan",aedit.mostCurrent._btnsimpan,"HttpUtils2Service",Debug.moduleToString(b4a.example.httputils2service.class),"kodeitem",aedit._kodeitem,"Main",Debug.moduleToString(b4a.example.main.class),"MultipartPost",Debug.moduleToString(b4a.example.multipartpost.class),"Starter",Debug.moduleToString(b4a.example.starter.class),"txtHargaitem",aedit.mostCurrent._txthargaitem,"txtKodeitem",aedit.mostCurrent._txtkodeitem,"txtNamaitem",aedit.mostCurrent._txtnamaitem};
}
}