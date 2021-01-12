function getR(){
    var R = document.getElementsByName("R")[0].value;
    return R;
}
document.getElementById("zoneCanvas").addEventListener("click", function (e) {
    if(true) {
        const x = (e.x - document.getElementById("zoneCanvas").getBoundingClientRect().left - 180) / (30);
        const y = (e.y - document.getElementById("zoneCanvas").getBoundingClientRect().top - 180) / (-30);
        const r = getR();
        onPointCliecked(x,y,r);
    }
});

function updateR() {
    let R = getR();
    update([{name:'dbR', value: R}]);
}