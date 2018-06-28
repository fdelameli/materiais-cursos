window["PR_SHOULD_USE_CONTINUATION"]=true;
window["PR_TAB_WIDTH"]=8;
window["PR_normalizedHtml"]=window["PR"]=window["prettyPrintOne"]=window["prettyPrint"]=void 0;
window["_pr_isIE6"]=function(){
var _1=navigator&&navigator.userAgent&&/\bMSIE 6\./.test(navigator.userAgent);
window["_pr_isIE6"]=function(){
return _1;
};
return _1;
};
(function(){
function _2(_3){
_3=_3.split(/ /g);
var _4={};
for(var i=_3.length;--i>=0;){
var w=_3[i];
if(w){
_4[w]=null;
}
}
return _4;
};
var _7="break continue do else for if return while ";
var _8=_7+"auto case char const default "+"double enum extern float goto int long register short signed sizeof "+"static struct switch typedef union unsigned void volatile ";
var _9=_8+"catch class delete false import "+"new operator private protected public this throw true try ";
var _a=_9+"alignof align_union asm axiom bool "+"concept concept_map const_cast constexpr decltype "+"dynamic_cast explicit export friend inline late_check "+"mutable namespace nullptr reinterpret_cast static_assert static_cast "+"template typeid typename typeof using virtual wchar_t where ";
var _b=_9+"boolean byte extends final finally implements import instanceof null "+"native package strictfp super synchronized throws transient ";
var _c=_b+"as base by checked decimal delegate descending event "+"fixed foreach from group implicit in interface internal into is lock "+"object out override orderby params readonly ref sbyte sealed "+"stackalloc string select uint ulong unchecked unsafe ushort var ";
var _d=_9+"debugger eval export function get null set undefined var with "+"Infinity NaN ";
var _e="caller delete die do dump elsif eval exit foreach for "+"goto if import last local my next no our print package redo require "+"sub undef unless until use wantarray while BEGIN END ";
var _f=_7+"and as assert class def del "+"elif except exec finally from global import in is lambda "+"nonlocal not or pass print raise try with yield "+"False True None ";
var _10=_7+"alias and begin case class def"+" defined elsif end ensure false in module next nil not or redo rescue "+"retry self super then true undef unless until when yield BEGIN END ";
var _11=_7+"case done elif esac eval fi "+"function in local set then until ";
var _12=(_a+_c+_d+_e+_f+_10+_11);
var _13="str";
var _14="kwd";
var _15="com";
var _16="typ";
var _17="lit";
var _18="pun";
var _19="pln";
var _1a="tag";
var _1b="dec";
var _1c="src";
var _1d="atn";
var _1e="atv";
var _1f="nocode";
function _20(ch){
return (ch>="a"&&ch<="z")||(ch>="A"&&ch<="Z");
};
function _22(_23,_24,_25,_26){
_23.unshift(_25,_26||0);
try{
_24.splice.apply(_24,_23);
}
finally{
_23.splice(0,2);
}
};
var _27=function(){
var _28=["!","!=","!==","#","%","%=","&","&&","&&=","&=","(","*","*=","+=",",","-=","->","/","/=",":","::",";","<","<<","<<=","<=","=","==","===",">",">=",">>",">>=",">>>",">>>=","?","@","[","^","^=","^^","^^=","{","|","|=","||","||=","~","break","case","continue","delete","do","else","finally","instanceof","return","throw","try","typeof"];
var _29="(?:"+"(?:(?:^|[^0-9.])\\.{1,3})|"+"(?:(?:^|[^\\+])\\+)|"+"(?:(?:^|[^\\-])-)";
for(var i=0;i<_28.length;++i){
var _2b=_28[i];
if(_20(_2b.charAt(0))){
_29+="|\\b"+_2b;
}else{
_29+="|"+_2b.replace(/([^=<>:&])/g,"\\$1");
}
}
_29+="|^)\\s*$";
return new RegExp(_29);
}();
var _2c=/&/g;
var _2d=/</g;
var _2e=/>/g;
var _2f=/\"/g;
function _30(str){
return str.replace(_2c,"&amp;").replace(_2d,"&lt;").replace(_2e,"&gt;").replace(_2f,"&quot;");
};
function _32(str){
return str.replace(_2c,"&amp;").replace(_2d,"&lt;").replace(_2e,"&gt;");
};
var _34=/&lt;/g;
var _35=/&gt;/g;
var _36=/&apos;/g;
var _37=/&quot;/g;
var _38=/&amp;/g;
var _39=/&nbsp;/g;
function _3a(_3b){
var pos=_3b.indexOf("&");
if(pos<0){
return _3b;
}
for(--pos;(pos=_3b.indexOf("&#",pos+1))>=0;){
var end=_3b.indexOf(";",pos);
if(end>=0){
var num=_3b.substring(pos+3,end);
var _3f=10;
if(num&&num.charAt(0)==="x"){
num=num.substring(1);
_3f=16;
}
var _40=parseInt(num,_3f);
if(!isNaN(_40)){
_3b=(_3b.substring(0,pos)+String.fromCharCode(_40)+_3b.substring(end+1));
}
}
}
return _3b.replace(_34,"<").replace(_35,">").replace(_36,"'").replace(_37,"\"").replace(_38,"&").replace(_39," ");
};
function _41(_42){
return "XMP"===_42.tagName;
};
function _43(_44,out){
switch(_44.nodeType){
case 1:
var _46=_44.tagName.toLowerCase();
out.push("<",_46);
for(var i=0;i<_44.attributes.length;++i){
var _48=_44.attributes[i];
if(!_48.specified){
continue;
}
out.push(" ");
_43(_48,out);
}
out.push(">");
for(var _49=_44.firstChild;_49;_49=_49.nextSibling){
_43(_49,out);
}
if(_44.firstChild||!/^(?:br|link|img)$/.test(_46)){
out.push("</",_46,">");
}
break;
case 2:
out.push(_44.name.toLowerCase(),"=\"",_30(_44.value),"\"");
break;
case 3:
case 4:
out.push(_32(_44.nodeValue));
break;
}
};
var _4a=null;
function _4b(_4c){
if(null===_4a){
var _4d=document.createElement("PRE");
_4d.appendChild(document.createTextNode("<!DOCTYPE foo PUBLIC \"foo bar\">\n<foo />"));
_4a=!/</.test(_4d.innerHTML);
}
if(_4a){
var _4e=_4c.innerHTML;
if(_41(_4c)){
_4e=_32(_4e);
}
return _4e;
}
var out=[];
for(var _50=_4c.firstChild;_50;_50=_50.nextSibling){
_43(_50,out);
}
return out.join("");
};
function _51(_52){
var _53="                ";
var _54=0;
return function(_55){
var out=null;
var pos=0;
for(var i=0,n=_55.length;i<n;++i){
var ch=_55.charAt(i);
switch(ch){
case "\t":
if(!out){
out=[];
}
out.push(_55.substring(pos,i));
var _5b=_52-(_54%_52);
_54+=_5b;
for(;_5b>=0;_5b-=_53.length){
out.push(_53.substring(0,_5b));
}
pos=i+1;
break;
case "\n":
_54=0;
break;
default:
++_54;
}
}
if(!out){
return _55;
}
out.push(_55.substring(pos));
return out.join("");
};
};
var _5c=/(?:[^<]+|<!--[\s\S]*?-->|<!\[CDATA\[([\s\S]*?)\]\]>|<\/?[a-zA-Z][^>]*>|<)/g;
var _5d=/^<!--/;
var _5e=/^<\[CDATA\[/;
var _5f=/^<br\b/i;
var _60=/^<(\/?)([a-zA-Z]+)/;
function _61(s){
var _63=s.match(_5c);
var _64=[];
var _65=0;
var _66=[];
if(_63){
for(var i=0,n=_63.length;i<n;++i){
var _69=_63[i];
if(_69.length>1&&_69.charAt(0)==="<"){
if(_5d.test(_69)){
continue;
}
if(_5e.test(_69)){
_64.push(_69.substring(9,_69.length-3));
_65+=_69.length-12;
}else{
if(_5f.test(_69)){
_64.push("\n");
++_65;
}else{
if(_69.indexOf(_1f)>=0&&_6a(_69)){
var _6b=_69.match(_60)[2];
var _6c=1;
var j;
end_tag_loop:
for(j=i+1;j<n;++j){
var _6e=_63[j].match(_60);
if(_6e&&_6e[2]===_6b){
if(_6e[1]==="/"){
if(--_6c===0){
break end_tag_loop;
}
}else{
++_6c;
}
}
}
if(j<n){
_66.push(_65,_63.slice(i,j+1).join(""));
i=j;
}else{
_66.push(_65,_69);
}
}else{
_66.push(_65,_69);
}
}
}
}else{
var _6f=_3a(_69);
_64.push(_6f);
_65+=_6f.length;
}
}
}
return {source:_64.join(""),tags:_66};
};
function _6a(tag){
return !!tag.replace(/\s(\w+)\s*=\s*(?:\"([^\"]*)\"|'([^\']*)'|(\S+))/g," $1=\"$2$3$4\"").match(/[cC][lL][aA][sS][sS]=\"[^\"]*\bnocode\b/);
};
function _71(_72,_73,_74,out){
if(!_73){
return;
}
var _76=_74.call({},_73);
if(_72){
for(var i=_76.length;(i-=2)>=0;){
_76[i]+=_72;
}
}
out.push.apply(out,_76);
};
function _78(_79,_7a){
var _7b={};
(function(){
var _7c=_79.concat(_7a);
for(var i=_7c.length;--i>=0;){
var _7e=_7c[i];
var _7f=_7e[3];
if(_7f){
for(var c=_7f.length;--c>=0;){
_7b[_7f.charAt(c)]=_7e;
}
}
}
})();
var _81=_7a.length;
var _82=/\S/;
var _83=function(_84,_85){
_85=_85||0;
var _86=[_85,_19];
var _87="";
var pos=0;
var _89=_84;
while(_89.length){
var _8a;
var _8b=null;
var _8c;
var _8d=_7b[_89.charAt(0)];
if(_8d){
_8c=_89.match(_8d[1]);
_8b=_8c[0];
_8a=_8d[0];
}else{
for(var i=0;i<_81;++i){
_8d=_7a[i];
var _8f=_8d[2];
if(_8f&&!_8f.test(_87)){
continue;
}
_8c=_89.match(_8d[1]);
if(_8c){
_8b=_8c[0];
_8a=_8d[0];
break;
}
}
if(!_8b){
_8a=_19;
_8b=_89.substring(0,1);
}
}
var _90="lang-"===_8a.substring(0,5);
if(_90&&!(_8c&&_8c[1])){
_90=false;
_8a=_1c;
}
if(!_90){
_86.push(_85+pos,_8a);
}else{
var _91=_8c[1];
var _92=_8b.indexOf(_91);
var _93=_92+_91.length;
var _94=_8a.substring(5);
if(!_95.hasOwnProperty(_94)){
_94=/^\s*</.test(_91)?"default-markup":"default-code";
}
var _96=_86.length-10;
_71(_85+pos,_8b.substring(0,_92),_83,_86);
_71(_85+pos+_92,_8b.substring(_92,_93),_95[_94],_86);
_71(_85+pos+_93,_8b.substring(_93),_83,_86);
}
pos+=_8b.length;
_89=_89.substring(_8b.length);
if(_8a!==_15&&_82.test(_8b)){
_87=_8b;
}
}
return _86;
};
return _83;
};
var _97=_78([],[[_19,/^[^<?]+/,null],[_1b,/^<!\w[^>]*(?:>|$)/,null],[_15,/^<!--[\s\S]*?(?:-->|$)/,null],["lang-",/^<\?([\s\S]+?)(?:\?>|$)/,null],["lang-",/^<%([\s\S]+?)(?:%>|$)/,null],[_18,/^(?:<[%?]|[%?]>)/,null],["lang-",/^<xmp\b[^>]*>([\s\S]+?)<\/xmp\b[^>]*>/i,null],["lang-js",/^<script\b[^>]*>([\s\S]+?)<\/script\b[^>]*>/i,null],["lang-css",/^<style\b[^>]*>([\s\S]+?)<\/style\b[^>]*>/i,null],[_1a,/^<\/?\w[^<>]*>/,null]]);
var _98=/^(<[^>]*>)([\s\S]*)(<\/[^>]*>)$/;
function _99(_9a){
var _9b=_97(_9a);
for(var i=0;i<_9b.length;i+=2){
if(_9b[i+1]===_1c){
var _9d,end;
_9d=_9b[i];
end=i+2<_9b.length?_9b[i+2]:_9a.length;
var _9f=_9a.substring(_9d,end);
var _a0=_9f.match(_98);
if(_a0){
_9b.splice(i,2,_9d,_1a,_9d+_a0[1].length,_1c,_9d+_a0[1].length+(_a0[2]||"").length,_1a);
}
}
}
return _9b;
};
var _a1=_78([[_1e,/^\'[^\']*(?:\'|$)/,null,"'"],[_1e,/^\"[^\"]*(?:\"|$)/,null,"\""],[_18,/^[<>\/=]+/,null,"<>/="]],[[_1a,/^[\w:\-]+/,/^</],[_1e,/^[\w\-]+/,/^=/],[_1d,/^[\w:\-]+/,null],[_19,/^\s+/,null," \t\r\n"]]);
function _a2(_a3,_a4){
for(var i=0;i<_a4.length;i+=2){
var _a6=_a4[i+1];
if(_a6===_1a){
var _a7,end;
_a7=_a4[i];
end=i+2<_a4.length?_a4[i+2]:_a3.length;
var _a9=_a3.substring(_a7,end);
var _aa=_a1(_a9,_a7);
_22(_aa,_a4,i,2);
i+=_aa.length-2;
}
}
return _a4;
};
function _ab(_ac){
var _ad=[],_ae=[];
if(_ac["tripleQuotedStrings"]){
_ad.push([_13,/^(?:\'\'\'(?:[^\'\\]|\\[\s\S]|\'{1,2}(?=[^\']))*(?:\'\'\'|$)|\"\"\"(?:[^\"\\]|\\[\s\S]|\"{1,2}(?=[^\"]))*(?:\"\"\"|$)|\'(?:[^\\\']|\\[\s\S])*(?:\'|$)|\"(?:[^\\\"]|\\[\s\S])*(?:\"|$))/,null,"'\""]);
}else{
if(_ac["multiLineStrings"]){
_ad.push([_13,/^(?:\'(?:[^\\\']|\\[\s\S])*(?:\'|$)|\"(?:[^\\\"]|\\[\s\S])*(?:\"|$)|\`(?:[^\\\`]|\\[\s\S])*(?:\`|$))/,null,"'\"`"]);
}else{
_ad.push([_13,/^(?:\'(?:[^\\\'\r\n]|\\.)*(?:\'|$)|\"(?:[^\\\"\r\n]|\\.)*(?:\"|$))/,null,"\"'"]);
}
}
_ae.push([_19,/^(?:[^\'\"\`\/\#]+)/,null," \r\n"]);
if(_ac["hashComments"]){
_ad.push([_15,/^#[^\r\n]*/,null,"#"]);
}
if(_ac["cStyleComments"]){
_ae.push([_15,/^\/\/[^\r\n]*/,null]);
_ae.push([_15,/^\/\*[\s\S]*?(?:\*\/|$)/,null]);
}
if(_ac["regexLiterals"]){
var _af=("^/(?=[^/*])"+"(?:[^/\\x5B\\x5C]"+"|\\x5C[\\s\\S]"+"|\\x5B(?:[^\\x5C\\x5D]|\\x5C[\\s\\S])*(?:\\x5D|$))+"+"(?:/|$)");
_ae.push([_13,new RegExp(_af),_27]);
}
var _b0=_2(_ac["keywords"]);
_ac=null;
var _b1=_78(_ad,_ae);
var _b2=_78([],[[_19,/^\s+/,null," \r\n"],[_19,/^[a-z_$@][a-z_$@0-9]*/i,null],[_17,/^0x[a-f0-9]+[a-z]/i,null],[_17,/^(?:\d(?:_\d+)*\d*(?:\.\d*)?|\.\d+)(?:e[+\-]?\d+)?[a-z]*/i,null,"123456789"],[_18,/^[^\s\w\.$@]+/,null]]);
function _b3(_b4,_b5){
for(var i=0;i<_b5.length;i+=2){
var _b7=_b5[i+1];
if(_b7===_19){
var _b8,end,_ba,_bb;
_b8=_b5[i];
end=i+2<_b5.length?_b5[i+2]:_b4.length;
_ba=_b4.substring(_b8,end);
_bb=_b2(_ba,_b8);
for(var j=0,m=_bb.length;j<m;j+=2){
var _be=_bb[j+1];
if(_be===_19){
var _bf=_bb[j];
var _c0=j+2<m?_bb[j+2]:_ba.length;
var _c1=_b4.substring(_bf,_c0);
if(_c1==="."){
_bb[j+1]=_18;
}else{
if(_c1 in _b0){
_bb[j+1]=_14;
}else{
if(/^@?[A-Z][A-Z$]*[a-z][A-Za-z$]*$/.test(_c1)){
_bb[j+1]=_c1.charAt(0)==="@"?_17:_16;
}
}
}
}
}
_22(_bb,_b5,i,2);
i+=_bb.length-2;
}
}
return _b5;
};
return function(_c2){
var _c3=_b1(_c2);
_c3=_b3(_c2,_c3);
return _c3;
};
};
var _c4=_ab({"keywords":_12,"hashComments":true,"cStyleComments":true,"multiLineStrings":true,"regexLiterals":true});
function _c5(_c6,_c7){
var _c8=false;
for(var i=0;i<_c7.length;i+=2){
var _ca=_c7[i+1];
var _cb,end;
if(_ca===_1d){
_cb=_c7[i];
end=i+2<_c7.length?_c7[i+2]:_c6.length;
_c8=/^on|^style$/i.test(_c6.substring(_cb,end));
}else{
if(_ca===_1e){
if(_c8){
_cb=_c7[i];
end=i+2<_c7.length?_c7[i+2]:_c6.length;
var _cd=_c6.substring(_cb,end);
var _ce=_cd.length;
var _cf=(_ce>=2&&/^[\"\']/.test(_cd)&&_cd.charAt(0)===_cd.charAt(_ce-1));
var _d0;
var _d1;
var _d2;
if(_cf){
_d1=_cb+1;
_d2=end-1;
_d0=_cd;
}else{
_d1=_cb+1;
_d2=end-1;
_d0=_cd.substring(1,_cd.length-1);
}
var _d3=_c4(_d0);
for(var j=0,m=_d3.length;j<m;j+=2){
_d3[j]+=_d1;
}
if(_cf){
_d3.push(_d2,_1e);
_22(_d3,_c7,i+2,0);
}else{
_22(_d3,_c7,i,2);
}
}
_c8=false;
}
}
}
return _c7;
};
function _d6(_d7){
var _d8=_99(_d7);
_d8=_a2(_d7,_d8);
_d8=_c5(_d7,_d8);
return _d8;
};
function _d9(_da,_db,_dc){
var _dd=[];
var _de=0;
var _df=null;
var _e0=null;
var _e1=0;
var _e2=0;
var _e3=_51(window["PR_TAB_WIDTH"]);
var _e4=/([\r\n ]) /g;
var _e5=/(^| ) /gm;
var _e6=/\r\n?|\n/g;
var _e7=/[ \r\n]$/;
var _e8=true;
function _e9(_ea){
if(_ea>_de){
if(_df&&_df!==_e0){
_dd.push("</span>");
_df=null;
}
if(!_df&&_e0){
_df=_e0;
_dd.push("<span class=\"",_df,"\">");
}
var _eb=_32(_e3(_da.substring(_de,_ea))).replace(_e8?_e5:_e4,"$1&nbsp;");
_e8=_e7.test(_eb);
_dd.push(_eb.replace(_e6,"<br />"));
_de=_ea;
}
};
while(true){
var _ec;
if(_e1<_db.length){
if(_e2<_dc.length){
_ec=_db[_e1]<=_dc[_e2];
}else{
_ec=true;
}
}else{
_ec=false;
}
if(_ec){
_e9(_db[_e1]);
if(_df){
_dd.push("</span>");
_df=null;
}
_dd.push(_db[_e1+1]);
_e1+=2;
}else{
if(_e2<_dc.length){
_e9(_dc[_e2]);
_e0=_dc[_e2+1];
_e2+=2;
}else{
break;
}
}
}
_e9(_da.length);
if(_df){
_dd.push("</span>");
}
return _dd.join("");
};
var _95={};
function _ed(_ee,_ef){
for(var i=_ef.length;--i>=0;){
var ext=_ef[i];
if(!_95.hasOwnProperty(ext)){
_95[ext]=_ee;
}else{
if("console" in window){
console.log("cannot override language handler %s",ext);
}
}
}
};
_ed(_c4,["default-code"]);
_ed(_d6,["default-markup","htm","html","mxml","xhtml","xml","xsl"]);
_ed(_ab({"keywords":_a,"hashComments":true,"cStyleComments":true}),["c","cc","cpp","cxx","cyc","m"]);
_ed(_ab({"keywords":_c,"hashComments":true,"cStyleComments":true}),["cs"]);
_ed(_ab({"keywords":_b,"cStyleComments":true}),["java"]);
_ed(_ab({"keywords":_11,"hashComments":true,"multiLineStrings":true}),["bsh","csh","sh"]);
_ed(_ab({"keywords":_f,"hashComments":true,"multiLineStrings":true,"tripleQuotedStrings":true}),["cv","py"]);
_ed(_ab({"keywords":_e,"hashComments":true,"multiLineStrings":true,"regexLiterals":true}),["perl","pl","pm"]);
_ed(_ab({"keywords":_10,"hashComments":true,"multiLineStrings":true,"regexLiterals":true}),["rb"]);
_ed(_ab({"keywords":_d,"cStyleComments":true,"regexLiterals":true}),["js"]);
function _f2(_f3,_f4){
try{
var _f5=_61(_f3);
var _f6=_f5.source;
var _f7=_f5.tags;
if(!_95.hasOwnProperty(_f4)){
_f4=/^\s*</.test(_f6)?"default-markup":"default-code";
}
var _f8=_95[_f4].call({},_f6);
return _d9(_f6,_f7,_f8);
}
catch(e){
if("console" in window){
console.log(e);
console.trace();
}
return _f3;
}
};
function _f9(_fa){
var _fb=window["_pr_isIE6"]();
var _fc=document.getElementsByTagName("div");
var _fd=new Array;
var e=0;
for(var i=0;i<_fc.length;i++){
if(_fc[i].getAttribute("class")=="codigo"){
_fd[e]=_fc[i];
e++;
}
}
var _100=[_fd,document.getElementsByTagName("pre"),document.getElementsByTagName("code"),document.getElementsByTagName("xmp")];
var _101=[];
for(var i=0;i<_100.length;++i){
for(var j=0,n=_100[i].length;j<n;++j){
_101.push(_100[i][j]);
}
}
_100=null;
var k=0;
function _105(){
var _106=(window["PR_SHOULD_USE_CONTINUATION"]?new Date().getTime()+250:Infinity);
for(;k<_101.length&&new Date().getTime()<_106;k++){
var cs=_101[k];
if(cs.className&&cs.className.indexOf("codigo")>=0){
var _108=cs.className.match(/\blang-(\w+)\b/);
if(_108){
_108=_108[1];
}
var _109=false;
for(var p=cs.parentNode;p;p=p.parentNode){
if((p.tagName==="pre"||p.tagName==="code"||p.tagName==="xmp"||p.tagName==="div")&&p.className&&p.className.indexOf("codigo")>=0){
_109=true;
break;
}
}
if(!_109){
var _10b=_4b(cs.childNodes[0].childNodes[0]);
_10b=_10b.replace(/(?:\r\n?|\n)$/,"");
var _10c=_f2(_10b,_108);
if(!_41(cs)){
cs.childNodes[0].childNodes[0].innerHTML=_10c;
}else{
var pre=document.createElement("PRE");
for(var i=0;i<cs.attributes.length;++i){
var a=cs.attributes[i];
if(a.specified){
var _110=a.name.toLowerCase();
if(_110==="class"){
pre.className=a.value;
}else{
pre.setAttribute(a.name,a.value);
}
}
}
pre.innerHTML=_10c;
cs.parentNode.replaceChild(pre,cs);
cs=pre;
}
if(_fb&&cs.tagName==="PRE"){
var _111=cs.getElementsByTagName("br");
for(var j=_111.length;--j>=0;){
var _113=_111[j];
_113.parentNode.replaceChild(document.createTextNode("\r\n"),_113);
}
}
}
}
}
if(k<_101.length){
setTimeout(_105,250);
}else{
if(_fa){
_fa();
}
}
};
_105();
};
window["PR_normalizedHtml"]=_43;
window["prettyPrintOne"]=_f2;
window["prettyPrint"]=_f9;
window["PR"]={"createSimpleLexer":_78,"registerLangHandler":_ed,"sourceDecorator":_ab,"PR_ATTRIB_NAME":_1d,"PR_ATTRIB_VALUE":_1e,"PR_COMMENT":_15,"PR_DECLARATION":_1b,"PR_KEYWORD":_14,"PR_LITERAL":_17,"PR_NOCODE":_1f,"PR_PLAIN":_19,"PR_PUNCTUATION":_18,"PR_SOURCE":_1c,"PR_STRING":_13,"PR_TAG":_1a,"PR_TYPE":_16};
})();

