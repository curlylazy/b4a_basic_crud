package b4a.example;

import anywheresoftware.b4a.BA;
import anywheresoftware.b4a.pc.*;

public class multipartpost_subs_0 {


public static RemoteObject  _createpostrequest(RemoteObject _ba,RemoteObject _url,RemoteObject _namevalues,RemoteObject _files) throws Exception{
try {
		Debug.PushSubsStack("CreatePostRequest (multipartpost) ","multipartpost",4,_ba,multipartpost.mostCurrent,7);
if (RapidSub.canDelegate("createpostrequest")) { return b4a.example.multipartpost.remoteMe.runUserSub(false, "multipartpost","createpostrequest", _ba, _url, _namevalues, _files);}
RemoteObject _boundary = RemoteObject.createImmutable("");
RemoteObject _stream = RemoteObject.declareNull("anywheresoftware.b4a.objects.streams.File.OutputStreamWrapper");
RemoteObject _eol = RemoteObject.createImmutable("");
RemoteObject _b = null;
RemoteObject _key = RemoteObject.createImmutable("");
RemoteObject _value = RemoteObject.createImmutable("");
int _i = 0;
RemoteObject _fd = RemoteObject.declareNull("b4a.example.multipartpost._filedata");
RemoteObject _in = RemoteObject.declareNull("anywheresoftware.b4a.objects.streams.File.InputStreamWrapper");
RemoteObject _request = RemoteObject.declareNull("anywheresoftware.b4h.okhttp.OkHttpClientWrapper.OkHttpRequest");
;
Debug.locals.put("URL", _url);
Debug.locals.put("NameValues", _namevalues);
Debug.locals.put("Files", _files);
 BA.debugLineNum = 7;BA.debugLine="Sub CreatePostRequest(URL As String, NameValues As";
Debug.ShouldStop(64);
 BA.debugLineNum = 8;BA.debugLine="Dim boundary As String";
Debug.ShouldStop(128);
_boundary = RemoteObject.createImmutable("");Debug.locals.put("boundary", _boundary);
 BA.debugLineNum = 9;BA.debugLine="boundary = \"---------------------------1461124740";
Debug.ShouldStop(256);
_boundary = BA.ObjectToString("---------------------------1461124740692");Debug.locals.put("boundary", _boundary);
 BA.debugLineNum = 10;BA.debugLine="Dim stream As OutputStream";
Debug.ShouldStop(512);
_stream = RemoteObject.createNew ("anywheresoftware.b4a.objects.streams.File.OutputStreamWrapper");Debug.locals.put("stream", _stream);
 BA.debugLineNum = 11;BA.debugLine="stream.InitializeToBytesArray(20)";
Debug.ShouldStop(1024);
_stream.runVoidMethod ("InitializeToBytesArray",(Object)(BA.numberCast(int.class, 20)));
 BA.debugLineNum = 12;BA.debugLine="Dim EOL As String";
Debug.ShouldStop(2048);
_eol = RemoteObject.createImmutable("");Debug.locals.put("EOL", _eol);
 BA.debugLineNum = 13;BA.debugLine="EOL = Chr(13) & Chr(10) 'CRLF constant matches An";
Debug.ShouldStop(4096);
_eol = RemoteObject.concat(multipartpost.mostCurrent.__c.runMethod(true,"Chr",(Object)(BA.numberCast(int.class, 13))),multipartpost.mostCurrent.__c.runMethod(true,"Chr",(Object)(BA.numberCast(int.class, 10))));Debug.locals.put("EOL", _eol);
 BA.debugLineNum = 14;BA.debugLine="Dim b() As Byte";
Debug.ShouldStop(8192);
_b = RemoteObject.createNewArray ("byte", new int[] {0}, new Object[]{});Debug.locals.put("b", _b);
 BA.debugLineNum = 15;BA.debugLine="If NameValues <> Null And NameValues.IsInitialize";
Debug.ShouldStop(16384);
if (RemoteObject.solveBoolean("N",_namevalues) && RemoteObject.solveBoolean(".",_namevalues.runMethod(true,"IsInitialized"))) { 
 BA.debugLineNum = 17;BA.debugLine="Dim key, value As String";
Debug.ShouldStop(65536);
_key = RemoteObject.createImmutable("");Debug.locals.put("key", _key);
_value = RemoteObject.createImmutable("");Debug.locals.put("value", _value);
 BA.debugLineNum = 18;BA.debugLine="For i = 0 To NameValues.Size - 1";
Debug.ShouldStop(131072);
{
final int step10 = 1;
final int limit10 = RemoteObject.solve(new RemoteObject[] {_namevalues.runMethod(true,"getSize"),RemoteObject.createImmutable(1)}, "-",1, 1).<Integer>get().intValue();
_i = 0 ;
for (;(step10 > 0 && _i <= limit10) || (step10 < 0 && _i >= limit10) ;_i = ((int)(0 + _i + step10))  ) {
Debug.locals.put("i", _i);
 BA.debugLineNum = 19;BA.debugLine="key = NameValues.GetKeyAt(i)";
Debug.ShouldStop(262144);
_key = BA.ObjectToString(_namevalues.runMethod(false,"GetKeyAt",(Object)(BA.numberCast(int.class, _i))));Debug.locals.put("key", _key);
 BA.debugLineNum = 20;BA.debugLine="value = NameValues.GetValueAt(i)";
Debug.ShouldStop(524288);
_value = BA.ObjectToString(_namevalues.runMethod(false,"GetValueAt",(Object)(BA.numberCast(int.class, _i))));Debug.locals.put("value", _value);
 BA.debugLineNum = 21;BA.debugLine="b = (\"--\" & boundary & EOL & \"Content-Dispositi";
Debug.ShouldStop(1048576);
_b = (RemoteObject.concat(RemoteObject.createImmutable("--"),_boundary,_eol,RemoteObject.createImmutable("Content-Disposition: form-data; name="),multipartpost.mostCurrent.__c.getField(true,"QUOTE"),_key,multipartpost.mostCurrent.__c.getField(true,"QUOTE"),_eol,_eol,_value,_eol)).runMethod(false,"getBytes",(Object)(RemoteObject.createImmutable("UTF8")));Debug.locals.put("b", _b);
 BA.debugLineNum = 23;BA.debugLine="stream.WriteBytes(b, 0, b.Length)";
Debug.ShouldStop(4194304);
_stream.runVoidMethod ("WriteBytes",(Object)(_b),(Object)(BA.numberCast(int.class, 0)),(Object)(_b.getField(true,"length")));
 }
}Debug.locals.put("i", _i);
;
 };
 BA.debugLineNum = 26;BA.debugLine="If Files <> Null And Files.IsInitialized Then";
Debug.ShouldStop(33554432);
if (RemoteObject.solveBoolean("N",_files) && RemoteObject.solveBoolean(".",_files.runMethod(true,"IsInitialized"))) { 
 BA.debugLineNum = 28;BA.debugLine="Dim FD As FileData";
Debug.ShouldStop(134217728);
_fd = RemoteObject.createNew ("b4a.example.multipartpost._filedata");Debug.locals.put("FD", _fd);
 BA.debugLineNum = 29;BA.debugLine="For i = 0 To Files.Size - 1";
Debug.ShouldStop(268435456);
{
final int step19 = 1;
final int limit19 = RemoteObject.solve(new RemoteObject[] {_files.runMethod(true,"getSize"),RemoteObject.createImmutable(1)}, "-",1, 1).<Integer>get().intValue();
_i = 0 ;
for (;(step19 > 0 && _i <= limit19) || (step19 < 0 && _i >= limit19) ;_i = ((int)(0 + _i + step19))  ) {
Debug.locals.put("i", _i);
 BA.debugLineNum = 30;BA.debugLine="FD = Files.Get(i)";
Debug.ShouldStop(536870912);
_fd = (_files.runMethod(false,"Get",(Object)(BA.numberCast(int.class, _i))));Debug.locals.put("FD", _fd);
 BA.debugLineNum = 31;BA.debugLine="b = (\"--\" & boundary & EOL & \"Content-Dispositi";
Debug.ShouldStop(1073741824);
_b = (RemoteObject.concat(RemoteObject.createImmutable("--"),_boundary,_eol,RemoteObject.createImmutable("Content-Disposition: form-data; name="),multipartpost.mostCurrent.__c.getField(true,"QUOTE"),_fd.getField(true,"KeyName" /*RemoteObject*/ ),multipartpost.mostCurrent.__c.getField(true,"QUOTE"),RemoteObject.createImmutable("; filename="),multipartpost.mostCurrent.__c.getField(true,"QUOTE"),_fd.getField(true,"FileName" /*RemoteObject*/ ),multipartpost.mostCurrent.__c.getField(true,"QUOTE"),_eol,RemoteObject.createImmutable("Content-Type: "),_fd.getField(true,"ContentType" /*RemoteObject*/ ),_eol,_eol)).runMethod(false,"getBytes",(Object)(RemoteObject.createImmutable("UTF8")));Debug.locals.put("b", _b);
 BA.debugLineNum = 34;BA.debugLine="stream.WriteBytes(b, 0, b.Length)";
Debug.ShouldStop(2);
_stream.runVoidMethod ("WriteBytes",(Object)(_b),(Object)(BA.numberCast(int.class, 0)),(Object)(_b.getField(true,"length")));
 BA.debugLineNum = 35;BA.debugLine="Dim In As InputStream";
Debug.ShouldStop(4);
_in = RemoteObject.createNew ("anywheresoftware.b4a.objects.streams.File.InputStreamWrapper");Debug.locals.put("In", _in);
 BA.debugLineNum = 36;BA.debugLine="In = File.OpenInput(FD.Dir, FD.FileName)";
Debug.ShouldStop(8);
_in = multipartpost.mostCurrent.__c.getField(false,"File").runMethod(false,"OpenInput",(Object)(_fd.getField(true,"Dir" /*RemoteObject*/ )),(Object)(_fd.getField(true,"FileName" /*RemoteObject*/ )));Debug.locals.put("In", _in);
 BA.debugLineNum = 37;BA.debugLine="File.Copy2(In, stream) 'read the file and write";
Debug.ShouldStop(16);
multipartpost.mostCurrent.__c.getField(false,"File").runVoidMethod ("Copy2",(Object)((_in.getObject())),(Object)((_stream.getObject())));
 BA.debugLineNum = 38;BA.debugLine="b = EOL.GetBytes(\"UTF8\")";
Debug.ShouldStop(32);
_b = _eol.runMethod(false,"getBytes",(Object)(RemoteObject.createImmutable("UTF8")));Debug.locals.put("b", _b);
 BA.debugLineNum = 39;BA.debugLine="stream.WriteBytes(b, 0, b.Length)";
Debug.ShouldStop(64);
_stream.runVoidMethod ("WriteBytes",(Object)(_b),(Object)(BA.numberCast(int.class, 0)),(Object)(_b.getField(true,"length")));
 }
}Debug.locals.put("i", _i);
;
 };
 BA.debugLineNum = 42;BA.debugLine="b = (EOL & \"--\" & boundary & \"--\" & EOL).GetBytes";
Debug.ShouldStop(512);
_b = (RemoteObject.concat(_eol,RemoteObject.createImmutable("--"),_boundary,RemoteObject.createImmutable("--"),_eol)).runMethod(false,"getBytes",(Object)(RemoteObject.createImmutable("UTF8")));Debug.locals.put("b", _b);
 BA.debugLineNum = 43;BA.debugLine="stream.WriteBytes(b, 0, b.Length)";
Debug.ShouldStop(1024);
_stream.runVoidMethod ("WriteBytes",(Object)(_b),(Object)(BA.numberCast(int.class, 0)),(Object)(_b.getField(true,"length")));
 BA.debugLineNum = 44;BA.debugLine="b = stream.ToBytesArray";
Debug.ShouldStop(2048);
_b = _stream.runMethod(false,"ToBytesArray");Debug.locals.put("b", _b);
 BA.debugLineNum = 46;BA.debugLine="Dim request As OkHttpRequest";
Debug.ShouldStop(8192);
_request = RemoteObject.createNew ("anywheresoftware.b4h.okhttp.OkHttpClientWrapper.OkHttpRequest");Debug.locals.put("request", _request);
 BA.debugLineNum = 47;BA.debugLine="request.InitializePost2(URL, b)";
Debug.ShouldStop(16384);
_request.runVoidMethod ("InitializePost2",(Object)(_url),(Object)(_b));
 BA.debugLineNum = 48;BA.debugLine="request.SetContentType(\"multipart/form-data; boun";
Debug.ShouldStop(32768);
_request.runVoidMethod ("SetContentType",(Object)(RemoteObject.concat(RemoteObject.createImmutable("multipart/form-data; boundary="),_boundary)));
 BA.debugLineNum = 49;BA.debugLine="request.SetContentEncoding(\"UTF8\")";
Debug.ShouldStop(65536);
_request.runVoidMethod ("SetContentEncoding",(Object)(RemoteObject.createImmutable("UTF8")));
 BA.debugLineNum = 50;BA.debugLine="Return request";
Debug.ShouldStop(131072);
Debug.CheckDeviceExceptions();if (true) return _request;
 BA.debugLineNum = 51;BA.debugLine="End Sub";
Debug.ShouldStop(262144);
return RemoteObject.createImmutable(null);
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _process_globals() throws Exception{
 //BA.debugLineNum = 3;BA.debugLine="Sub Process_Globals";
 //BA.debugLineNum = 4;BA.debugLine="Type FileData (Dir As String, FileName As String,";
;
 //BA.debugLineNum = 5;BA.debugLine="End Sub";
return RemoteObject.createImmutable("");
}
}