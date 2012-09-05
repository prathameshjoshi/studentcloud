<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<html>
<head>
  <script src="http://code.jquery.com/jquery-latest.js"></script>
  <link href='<c:url value="/css/video-js.css"/>' rel="stylesheet" type="text/css" />
  <script src='<c:url value="/css/video.js"/>'></script>
  <script type="text/javascript">
   $(document).ready(function(){
	   var url = '${url}';
	   
     
var items = ${assets};
$.each(items, function(index, item){
     var element = item.split(".");
  var output = items[index];
  if(element[1] == "doc" || element[1] == "ods"){
	    $('#doc').append(output +
	    		'&nbsp;<input type="button" name="' + url +'/'+ output +'" id="download" value="Download" onClick="download(this.name)"/>&nbsp;<input type="button" name="' + url +'/'+ output +'" id="open" value="Open" onClick="docclick(this.name)"/><input type="button" name="'+ output +'" id="delete" value="Delete" onClick="deleteclick(this.name)"/><br/>');
	  }
  
  else if(element[1] == "mp4"){
    $('#mp4').append(output + 
    		'&nbsp;<input type="button" name="' + url +'/'+ output +'" id="download" value="Download" onClick="download(this.name)"/>&nbsp;<input type="button" name="' + url +'/'+ output +'" id="open" value="Open" onClick="playvideo(this.name)"/><input type="button" name="'+ output +'" id="delete" value="Delete" onClick="deleteclick(this.name)"<br/>');
  }
  else if(element[1] == "mp3"){
	    $('#mp3').append(output + 
	    		'&nbsp;<input type="button" name="' + url +'/'+ output +'" id="download" value="Download" onClick="download(this.name)"/>&nbsp;<input type="button" name="' + url +'/'+ output +'" id="open" value="Open" onClick="playaudio(this.name)"/><input type="button" name="'+ output +'" id="delete" value="Delete" onClick="deleteclick(this.name)"<br/>');
	  }
  
  else {
	     $('#other').append(output + 
	    		 '&nbsp;<input type="button" name="' + url +'/'+ output +'" id="download" value="Download" onClick="download(this.name)"/>&nbsp;<input type="button" value="Open"/><input type="button" name="'+ output +'" id="delete" value="Delete" onClick="deleteclick(this.name)"<br/>');
  }
});
   });
  </script>
  <script type="text/javascript">
function docclick(clicked_name)
{
	window.open('https://viewer.zoho.com/api/urlview.do?url='+ clicked_name);
}
function download(download_name)
{
	  window.location.href = download_name;
}
function playvideo(videourl){
	$('#mp4').slideDown('slow', function() {
		$('#mp4').append('<video id="example_video_1" class="video-js vjs-default-skin" controls preload="none" width="640" height="264" poster="http://video-js.zencoder.com/oceans-clip.png" data-setup="{}"> <source src="'+ videourl +'" type="video/mp4" /></video>');
	  });
}
function playaudio(audiourl){
	window.location.href = audiourl;	
}
function deleteclick(aname){
	var assname = aname;
	$.post("http://localhost:8080/spring-security-integration/krams/main", { assetname: assname });
}
  
</script>
  
</head>
<body><h1>${username}</h1><a href='<c:url value="/j_spring_security_logout"/>'>LogOut</a>
	<h3>File Browser</h3>
	<h1>Doc</h1>
  <div id="doc"></div>
  <h1>Video</h1>
  <div id="mp4"></div>
  <h1>Audio</h1>
  <div id="mp3"></div>
  <h1>Other</h1>
  <div id="other"></div>
 
	
	
	<br/><br/>
	<a href="main">Upload File</a>
	
	
 </body>
</html>
