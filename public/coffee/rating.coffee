parseId = (id) ->
  id.substring(0, id.indexOf("-"))
parseRate = (id)->
  parseInt(id[id.length-1])

toggleRated = (element) ->
  element.className = "rated"

window.toggleLeft = (id) ->
  index = parseRate(id)
  for i in [1..index]
    toggleRated(document.getElementById("#{parseId(id)}-#{i}"))

toggleUnrated = (element) ->
  element.className = "unrated"

toggleRight = (id) ->
  index = parseRate(id)
  for i in [5...index]
    toggleUnrated(document.getElementById("#{parseId(id)}-#{i}"))

toggle = (element) ->
  if element.className == "unrated"
    toggleLeft(element.id)
  else
    toggleRight(element.id)

updateRating = (pId, rate) ->
  $.ajax({
      type: "POST"
      url: "/updateRating"
      data: {postId: pId, newRating: rate}
    }).success ->
      console.log("rating updated")


jQuery ->
  $(".unrated").click (data) ->
    toggle(@)
    updateRating(parseId(@.id), parseRate(@.id))
  $(".rated").click (data) ->
    toggle(@)
    updateRating(parseId(@.id), parseRate(@.id))



