/*bind(position,id,func),call(position,id,target){{{*/

callbacks = {};

function bind(position,id,func){
	if(!callbacks[position]){
		callbacks[position] = {};
	}
	callbacks[position][id] = func;
}

function call(position,id,target){
	if(position && id && callbacks[position] && callbacks[position][id]){
		callbacks[position][id](target);
	}
}
/*}}}*/

/* $.loading {{{ */
$.extend({ loading: function(url,opts){
	
	if($.browser.msie && $.browser.version <= 8){
      window._xhr_ = window._xhr_ || 0;
      window._xhr_++;
      url = url.replace(/_=[^&]*/,'');
      url += url.indexOf('?') > -1 ? '&' : '?';
      url += '_='+(window._xhr_);
	}

  opts = $.extend({
    method:"get"
  },opts);

	
	var ajaxdata = opts.data;
    $.ajax({
      url:url,
      cache: false,
      type:opts.method,
      data:ajaxdata,
      dataType:"json",
      success:function(blocks){
      
        for(var i in blocks){

          var h = "#"+blocks[i].position + " .block-"+blocks[i].id;

          if($(h).size()>0){
            $(h).first().each(function(){
              this.innerHTML = $.b.c(blocks[i].data);
              blocks[i].uid = this.id;
            });
          }else{
            var o = $("<div id='"+blocks[i].uid+"' class='block block-"+blocks[i].id+"'>"+"</div>");
            o[0].innerHTML = $.b.c(blocks[i].data);
            $("#"+blocks[i].position).prepend(o);
          }
        }

        for(var i in blocks){
          call(blocks[i].position,blocks[i].id,"#"+blocks[i].uid);
        };

        opts.success && opts.success();
      },
      error:function(xhr, status, err){
        opts.error && opts.error();
      }
    });


		var hash = url.match(/#[a-zA-Z0-9\-]+$/);
		if(hash = hash && hash[0]){
			$("html,body").animate({ scrollTop: $(hash).offset().top},"fast");
    }
	}
});

$(function(){
	call("page",$("body").attr("id"),$("body"));
});