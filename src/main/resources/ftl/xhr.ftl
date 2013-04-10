[#if (block??) && (!(blocks??))][#assign blocks=[block] /][/#if]
[#if (!(blocks??))][#assign blocks=[] /][/#if]

[#if blocks??]
  [
    [#list blocks as block]
      [#if block_index > 0],[/#if]
      [#assign data][#include  'block/'+((block.id)?replace("-","/"))+'.ftl' /][/#assign]
      {
        "position":"${block.position}",
        "id":"${block.id}",
        "uid":"${block.uid}",
        "data":"${data?json_string}"
      }
    [/#list]
  ]
[/#if]
