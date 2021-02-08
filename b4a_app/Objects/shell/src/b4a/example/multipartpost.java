
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

public class multipartpost implements IRemote{
	public static multipartpost mostCurrent;
	public static RemoteObject processBA;
    public static boolean processGlobalsRun;
    public static RemoteObject myClass;
    public static RemoteObject remoteMe;
	public multipartpost() {
		mostCurrent = this;
	}
    public RemoteObject getRemoteMe() {
        return remoteMe;    
    }
    
public boolean isSingleton() {
		return true;
	}
     private static PCBA pcBA = new PCBA(null, multipartpost.class);
    static {
		mostCurrent = new multipartpost();
        remoteMe = RemoteObject.declareNull("b4a.example.multipartpost");
        anywheresoftware.b4a.pc.RapidSub.moduleToObject.put(new B4XClass("multipartpost"), "b4a.example.multipartpost");
        RDebug.INSTANCE.eventTargets.put(new DeviceClass("b4a.example.multipartpost"), new java.lang.ref.WeakReference<PCBA> (pcBA));
	}
   
	public static RemoteObject runMethod(boolean notUsed, String method, Object... args) throws Exception{
		return (RemoteObject) pcBA.raiseEvent(method.substring(1), args);
	}
    public static void runVoidMethod(String method, Object... args) throws Exception{
		runMethod(false, method, args);
	}
	public PCBA create(Object[] args) throws ClassNotFoundException{
        throw new RuntimeException("CREATE is not supported.");
	}
public static RemoteObject __c = RemoteObject.declareNull("anywheresoftware.b4a.keywords.Common");
public static b4a.example.main _main = null;
public static b4a.example.starter _starter = null;
public static b4a.example.alist _alist = null;
public static b4a.example.atambah _atambah = null;
public static b4a.example.aedit _aedit = null;
public static b4a.example.httputils2service _httputils2service = null;
  public Object[] GetGlobals() {
		return new Object[] {"aEDIT",Debug.moduleToString(b4a.example.aedit.class),"aLIST",Debug.moduleToString(b4a.example.alist.class),"aTAMBAH",Debug.moduleToString(b4a.example.atambah.class),"HttpUtils2Service",Debug.moduleToString(b4a.example.httputils2service.class),"Main",Debug.moduleToString(b4a.example.main.class),"Starter",Debug.moduleToString(b4a.example.starter.class)};
}
}