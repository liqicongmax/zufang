function beforeRegist() {
    if(!checkSize()){
        return false;
    }
    if(!checkBath()){
        return false;
    }
    if(!checkBeds()){
        return false;
    }
    if(!checkDescription()){
        return false;
    }
    if(!checkPrice()){
        return false;
    }
    if(!checkWc()){
        return false;
    }
    return true;
}
function checkSize(){
    var size=$("#size").val();
    if(size == ""){
        //$("#message1").removeClass();
        //$("#message1").addClass("message");
        $("#message1").html("*密码不能为空！");
        return false;
    }else{
        //$("#message1").removeClass();
        //$("#message1").addClass("message2");
        $("#message1").html("");
        return true;
    }
}
function checkPlace(){
    var place=$("#place").val();
    if(place == "") {
        //$("#message2").removeClass();
        $("#message7").html("*请输入房源的具体地址");
        return false;
    }else{
        //$("#message2").removeClass();
        $("#message7").html("");
        return true;
    }
}
function checkBath(){
    var bath=$("#bathroom").val();
    if(bath == "") {
        //$("#message2").removeClass();
        $("#message2").html("*请输入浴室个数");
        return false;
    }else{
        //$("#message2").removeClass();
        $("#message2").html("");
        return true;
    }
}
function checkBeds(){
    var beds=$("#beds").val();
    if(beds == "") {
        //$("#message3").removeClass();
        $("#message3").html("*请输入床位数");
        return false;
    }else{
        //$("#message3").removeClass();
        $("#message3").html("");
        return true;
    }
}
function checkWc(){
    var wc=$("#singleWc").val();
    if(wc == "") {
        // $("#message4").removeClass();
        $("#message4").html("*请输入卫生间数");
        return false;
    }else{
        // $("#message4").removeClass();
        $("#message4").html("");
        return true;
    }
}
function checkDescription(){
    var desc=$("#description").val();
    if(desc == "") {
        // $("#message5").removeClass();
        $("#message5").html("*房间描述不能为空");
        return false;
    }else{
        // $("#message5").removeClass();
        $("#message5").html("");
        return true;
    }
}
function checkPrice(){
    var price=$("#price").val();
    if(price == "") {
        // $("#message6").removeClass();
        $("#message6").html("*价格不能为空");
        return false;
    }else{
        // $("#message6").removeClass();
        $("#message6").html("");
        return true;
    }
}
