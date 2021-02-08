package b4a.example;


import anywheresoftware.b4a.BA;
import anywheresoftware.b4a.BALayout;
import anywheresoftware.b4a.debug.*;

public class multipartpost {
private static multipartpost mostCurrent = new multipartpost();
public static Object getObject() {
    throw new RuntimeException("Code module does not support this method.");
}
 
public static class _filedata{
public boolean IsInitialized;
public String Dir;
public String FileName;
public String KeyName;
public String ContentType;
public void Initialize() {
IsInitialized = true;
Dir = "";
FileName = "";
KeyName = "";
ContentType = "";
}
@Override
		public String toString() {
			return BA.TypeToString(this, false);
		}}
public anywheresoftware.b4a.keywords.Common __c = null;
public b4a.example.main _main = null;
public b4a.example.starter _starter = null;
public b4a.example.alist _alist = null;
public b4a.example.atambah _atambah = null;
public b4a.example.aedit _aedit = null;
public b4a.example.httputils2service _httputils2service = null;
public static anywheresoftware.b4h.okhttp.OkHttpClientWrapper.OkHttpRequest  _createpostrequest(anywheresoftware.b4a.BA _ba,String _url,anywheresoftware.b4a.objects.collections.Map _namevalues,anywheresoftware.b4a.objects.collections.List _files) throws Exception{
RDebugUtils.currentModule="multipartpost";
if (Debug.shouldDelegate(null, "createpostrequest", false))
	 {return ((anywheresoftware.b4h.okhttp.OkHttpClientWrapper.OkHttpRequest) Debug.delegate(null, "createpostrequest", new Object[] {_ba,_url,_namevalues,_files}));}
String _boundary = "";
anywheresoftware.b4a.objects.streams.File.OutputStreamWrapper _stream = null;
String _eol = "";
byte[] _b = null;
String _key = "";
String _value = "";
int _i = 0;
b4a.example.multipartpost._filedata _fd = null;
anywheresoftware.b4a.objects.streams.File.InputStreamWrapper _in = null;
anywheresoftware.b4h.okhttp.OkHttpClientWrapper.OkHttpRequest _request = null;
RDebugUtils.currentLine=24969216;
 //BA.debugLineNum = 24969216;BA.debugLine="Sub CreatePostRequest(URL As String, NameValues As";
RDebugUtils.currentLine=24969217;
 //BA.debugLineNum = 24969217;BA.debugLine="Dim boundary As String";
_boundary = "";
RDebugUtils.currentLine=24969218;
 //BA.debugLineNum = 24969218;BA.debugLine="boundary = \"---------------------------1461124740";
_boundary = "---------------------------1461124740692";
RDebugUtils.currentLine=24969219;
 //BA.debugLineNum = 24969219;BA.debugLine="Dim stream As OutputStream";
_stream = new anywheresoftware.b4a.objects.streams.File.OutputStreamWrapper();
RDebugUtils.currentLine=24969220;
 //BA.debugLineNum = 24969220;BA.debugLine="stream.InitializeToBytesArray(20)";
_stream.InitializeToBytesArray((int) (20));
RDebugUtils.currentLine=24969221;
 //BA.debugLineNum = 24969221;BA.debugLine="Dim EOL As String";
_eol = "";
RDebugUtils.currentLine=24969222;
 //BA.debugLineNum = 24969222;BA.debugLine="EOL = Chr(13) & Chr(10) 'CRLF constant matches An";
_eol = BA.ObjectToString(anywheresoftware.b4a.keywords.Common.Chr((int) (13)))+BA.ObjectToString(anywheresoftware.b4a.keywords.Common.Chr((int) (10)));
RDebugUtils.currentLine=24969223;
 //BA.debugLineNum = 24969223;BA.debugLine="Dim b() As Byte";
_b = new byte[(int) (0)];
;
RDebugUtils.currentLine=24969224;
 //BA.debugLineNum = 24969224;BA.debugLine="If NameValues <> Null And NameValues.IsInitialize";
if (_namevalues!= null && _namevalues.IsInitialized()) { 
RDebugUtils.currentLine=24969226;
 //BA.debugLineNum = 24969226;BA.debugLine="Dim key, value As String";
_key = "";
_value = "";
RDebugUtils.currentLine=24969227;
 //BA.debugLineNum = 24969227;BA.debugLine="For i = 0 To NameValues.Size - 1";
{
final int step10 = 1;
final int limit10 = (int) (_namevalues.getSize()-1);
_i = (int) (0) ;
for (;_i <= limit10 ;_i = _i + step10 ) {
RDebugUtils.currentLine=24969228;
 //BA.debugLineNum = 24969228;BA.debugLine="key = NameValues.GetKeyAt(i)";
_key = BA.ObjectToString(_namevalues.GetKeyAt(_i));
RDebugUtils.currentLine=24969229;
 //BA.debugLineNum = 24969229;BA.debugLine="value = NameValues.GetValueAt(i)";
_value = BA.ObjectToString(_namevalues.GetValueAt(_i));
RDebugUtils.currentLine=24969230;
 //BA.debugLineNum = 24969230;BA.debugLine="b = (\"--\" & boundary & EOL & \"Content-Dispositi";
_b = ("--"+_boundary+_eol+"Content-Disposition: form-data; name="+anywheresoftware.b4a.keywords.Common.QUOTE+_key+anywheresoftware.b4a.keywords.Common.QUOTE+_eol+_eol+_value+_eol).getBytes("UTF8");
RDebugUtils.currentLine=24969232;
 //BA.debugLineNum = 24969232;BA.debugLine="stream.WriteBytes(b, 0, b.Length)";
_stream.WriteBytes(_b,(int) (0),_b.length);
 }
};
 };
RDebugUtils.currentLine=24969235;
 //BA.debugLineNum = 24969235;BA.debugLine="If Files <> Null And Files.IsInitialized Then";
if (_files!= null && _files.IsInitialized()) { 
RDebugUtils.currentLine=24969237;
 //BA.debugLineNum = 24969237;BA.debugLine="Dim FD As FileData";
_fd = new b4a.example.multipartpost._filedata();
RDebugUtils.currentLine=24969238;
 //BA.debugLineNum = 24969238;BA.debugLine="For i = 0 To Files.Size - 1";
{
final int step19 = 1;
final int limit19 = (int) (_files.getSize()-1);
_i = (int) (0) ;
for (;_i <= limit19 ;_i = _i + step19 ) {
RDebugUtils.currentLine=24969239;
 //BA.debugLineNum = 24969239;BA.debugLine="FD = Files.Get(i)";
_fd = (b4a.example.multipartpost._filedata)(_files.Get(_i));
RDebugUtils.currentLine=24969240;
 //BA.debugLineNum = 24969240;BA.debugLine="b = (\"--\" & boundary & EOL & \"Content-Dispositi";
_b = ("--"+_boundary+_eol+"Content-Disposition: form-data; name="+anywheresoftware.b4a.keywords.Common.QUOTE+_fd.KeyName /*String*/ +anywheresoftware.b4a.keywords.Common.QUOTE+"; filename="+anywheresoftware.b4a.keywords.Common.QUOTE+_fd.FileName /*String*/ +anywheresoftware.b4a.keywords.Common.QUOTE+_eol+"Content-Type: "+_fd.ContentType /*String*/ +_eol+_eol).getBytes("UTF8");
RDebugUtils.currentLine=24969243;
 //BA.debugLineNum = 24969243;BA.debugLine="stream.WriteBytes(b, 0, b.Length)";
_stream.WriteBytes(_b,(int) (0),_b.length);
RDebugUtils.currentLine=24969244;
 //BA.debugLineNum = 24969244;BA.debugLine="Dim In As InputStream";
_in = new anywheresoftware.b4a.objects.streams.File.InputStreamWrapper();
RDebugUtils.currentLine=24969245;
 //BA.debugLineNum = 24969245;BA.debugLine="In = File.OpenInput(FD.Dir, FD.FileName)";
_in = anywheresoftware.b4a.keywords.Common.File.OpenInput(_fd.Dir /*String*/ ,_fd.FileName /*String*/ );
RDebugUtils.currentLine=24969246;
 //BA.debugLineNum = 24969246;BA.debugLine="File.Copy2(In, stream) 'read the file and write";
anywheresoftware.b4a.keywords.Common.File.Copy2((java.io.InputStream)(_in.getObject()),(java.io.OutputStream)(_stream.getObject()));
RDebugUtils.currentLine=24969247;
 //BA.debugLineNum = 24969247;BA.debugLine="b = EOL.GetBytes(\"UTF8\")";
_b = _eol.getBytes("UTF8");
RDebugUtils.currentLine=24969248;
 //BA.debugLineNum = 24969248;BA.debugLine="stream.WriteBytes(b, 0, b.Length)";
_stream.WriteBytes(_b,(int) (0),_b.length);
 }
};
 };
RDebugUtils.currentLine=24969251;
 //BA.debugLineNum = 24969251;BA.debugLine="b = (EOL & \"--\" & boundary & \"--\" & EOL).GetBytes";
_b = (_eol+"--"+_boundary+"--"+_eol).getBytes("UTF8");
RDebugUtils.currentLine=24969252;
 //BA.debugLineNum = 24969252;BA.debugLine="stream.WriteBytes(b, 0, b.Length)";
_stream.WriteBytes(_b,(int) (0),_b.length);
RDebugUtils.currentLine=24969253;
 //BA.debugLineNum = 24969253;BA.debugLine="b = stream.ToBytesArray";
_b = _stream.ToBytesArray();
RDebugUtils.currentLine=24969255;
 //BA.debugLineNum = 24969255;BA.debugLine="Dim request As OkHttpRequest";
_request = new anywheresoftware.b4h.okhttp.OkHttpClientWrapper.OkHttpRequest();
RDebugUtils.currentLine=24969256;
 //BA.debugLineNum = 24969256;BA.debugLine="request.InitializePost2(URL, b)";
_request.InitializePost2(_url,_b);
RDebugUtils.currentLine=24969257;
 //BA.debugLineNum = 24969257;BA.debugLine="request.SetContentType(\"multipart/form-data; boun";
_request.SetContentType("multipart/form-data; boundary="+_boundary);
RDebugUtils.currentLine=24969258;
 //BA.debugLineNum = 24969258;BA.debugLine="request.SetContentEncoding(\"UTF8\")";
_request.SetContentEncoding("UTF8");
RDebugUtils.currentLine=24969259;
 //BA.debugLineNum = 24969259;BA.debugLine="Return request";
if (true) return _request;
RDebugUtils.currentLine=24969260;
 //BA.debugLineNum = 24969260;BA.debugLine="End Sub";
return null;
}
}