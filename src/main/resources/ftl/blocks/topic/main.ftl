[#assign topic = block.params.topic /]
<dl>
	<dt>
		<h2>${topic.title}</h2>
	</dt>
	<dd>
		<p>${topic.crdate?string("yyyy-MM-dd")}</p>
		<div>
			${topic.content}
		</div>
	</dd>
</dl>