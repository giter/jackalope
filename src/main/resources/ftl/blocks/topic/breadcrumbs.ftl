<ul>
	<li><a href='/'>HOME</a></li>
	[#if block.params.topic.category??]
		<li>&raquo;</li><li><a href='/category/${block.params.topic.category?url}.html'>${block.params.topic.category}</a></li>
	[/#if]
	<li>&raquo;</li><li>${block.params.topic.title!''}</li>
</ul>