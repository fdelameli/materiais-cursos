function ajaxAbre(pagina,id){
    var xmlHttp;
    try {
        // Firefox, Opera 8.0+, Safari
        xmlHttp=new XMLHttpRequest();
    }
    catch (e) {
        // Internet Explorer
        try {
            xmlHttp=new ActiveXObject("Msxml2.XMLHTTP");
        }
        catch (e){
            try {
                xmlHttp=new ActiveXObject("Microsoft.XMLHTTP");
            }
            catch (e) {
                alert("Seu navegador n‹o suporta AJAX. Atualize-o em www.getfirefox.com");
                return false;
            }
        }
    }
    
    xmlHttp.onreadystatechange=function() {
        if(xmlHttp.readyState == 1) {
            document.getElementById(id).innerHTML = "Carregando...<img src='./images/loading.gif'></img>";
        }
        if(xmlHttp.readyState == 4) {
            document.getElementById(id).innerHTML = xmlHttp.responseText;
            
        }
    }
    xmlHttp.open("GET",pagina,true);
    xmlHttp.send(null);
}
