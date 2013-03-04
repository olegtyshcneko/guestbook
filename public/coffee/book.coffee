jQuery ->
  $(":button#addbtn").click (e) =>
    if $(".sendForm").is ":visible"
      $(".sendForm").hide(250)
    else
      $(".sendForm").show(250)

window.editMessage = (postId) ->
  $("#"+postId).hide()
  $("##{postId}edit").show()


