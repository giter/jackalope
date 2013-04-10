[@compress single_line=true]
<!DOCTYPE html>
<html>
	<head>
		<meta http-equiv="content-type" content="text/html; charset=UTF-8" />
   		<link rel="shortcut icon" href="/favicon.ico" />
    	<link rel="stylesheet" type="text/css" href="/a.css?v=20130410" />
    	[#if attrs.title??]<title>${attrs.title?html}</title>[/#if]
    	[#if attrs.keywords??]<meta name="keywords" content="${attrs.keywords?html}" />[/#if]
    	[#if attrs.description??]<meta name="description" content="${attrs.description?html}" />[/#if]
	</head>
	
  <body [#if attrs.id??]id='${attrs.id}'[/#if]>
  
		<div id='container'>
	
      [#list ["hd"] as pos]
        <div id=${pos}>
          [#if blocks??]
          [#list blocks as block]
          [#include "/block.ftl" /]
          [/#list]
          [/#if]
        </div>
      [/#list]

      <div id='inner'>
        [#list ["head","aside","main","foot"] as pos]
          <div id=${pos}>
            [#if blocks??]
              [#list blocks as block]
                [#include "/block.ftl" /]
              [/#list]
            [/#if]
            </div>
        [/#list]
      </div>

      [#list ["ft"] as pos]
        <div id=${pos}>
          [#if blocks??]
          [#list blocks as block]
            [#include "/block.ftl" /]
          [/#list]
        [/#if]
        </div>
      [/#list]

 		</div>


    <script type='text/javascript' language='javascript' src="/jquery.js?20130118"></script>
    <script type='text/javascript' language='javascript' src="/a.js?20130118"></script>
    <script type='text/javascript' language='javascript' src="/binds.js?20130118"></script>

    [#if blocks??]
    <script type='text/javascript' language='javascript' charset="utf-8">
      $(function(){
        [#list blocks as block]call("${block.position}","${block.id}","#${block.uid}");[/#list]
      });
    </script>
    [/#if]

  </body>
</html>
[/@compress]