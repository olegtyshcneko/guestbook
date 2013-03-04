var parseId = function(id) {
    return id.substring(0, id.indexOf("-"));
};
var parseRate = function(id) {
    return parseInt(id[id.length-1]);
};

var toggleRated = function(element) {
    element.className = "rated";
};
var toggleLeft = function(id) {
    var index = parseRate(id);
    for(var i=1; i<=index; i++) {
        toggleRated(
            document.getElementById(parseId(id)+"-"+i));
    }
};
var toggleUnrated = function(element) {
    element.className = "unrated";
};
var toggleRight = function(id) {
    var index = parseRate(id);
    for(var i=5; i>index; i--) {
        toggleUnrated(
            document.getElementById(parseId(id)+"-"+i));
    }
};
var toggle = function(element) {
    if(element.className=="unrated") {
        toggleLeft(element.id);
    }
    else {
        toggleRight(element.id);
    }
};
var updateRating = function(pId, rate) {
    $.ajax({
        type: "POST",
        url: "/updateRating",
        data: {postId: pId, newRating: rate}
    }).success(function(){
            console.log("rating updated");
        });
};
$(function(){
    $(".unrated").click(function(data) {
        toggle(this);
        updateRating(parseId(this.id), parseRate(this.id));
    });
    $(".rated").click(function(data) {
        toggle(this);
        updateRating(parseId(this.id), parseRate(this.id));
    });
});