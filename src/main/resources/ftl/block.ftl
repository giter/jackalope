[#if block.position == pos]
  <div id='${block.uid}' class='block block-${block.id}'>
	  	[#include  'blocks/'+((block.id)?replace("-","/"))+'.ftl' /]
  </div>
[/#if]