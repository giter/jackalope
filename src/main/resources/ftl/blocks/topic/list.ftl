[#list block.params.topics as topic]
	${topic.crdate?string("yyyy-MM-dd")}
	${topic.title}
[/#list]