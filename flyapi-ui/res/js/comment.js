  var gather = {}, dom = {
    content: $('#L_content')
  };

  gather.commentActive = {
    reply: function(li){ //回复
      var val = dom.content.val();
      var aite = '@'+ li.find('.jie-user cite i').text().replace(/\s/g, '');
      dom.content.focus()
      if(val.indexOf(aite) !== -1) return;
      dom.content.val(aite +' ' + val);
    }

  };
  $('.comment-reply span').on('click', function(){
    var othis = $(this), type = othis.attr('type');
    gather.commentActive[type].call(this, othis.parents('li'));
  });
