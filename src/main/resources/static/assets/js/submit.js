function beforeSubmit(form) {
    if (document.form.province.value == '') {
        alert('省份名不能为空');
        form.province.focus();
        return false;
    }
    if (form.city.value == '') {
        alert('城市名不能为空');
        form.city.focus();
        return false;
    }
    if (form.district.value == '') {
        alert('地区名不能为空');
        form.district.focus();
        return false;
    }
    var low=document.getElementById("low");
    var high=document.getElementById("high");
    if(low.options[low.selectedIndex].value!="any"&&high.options[high.selectedIndex].value!="any"){
        if(low.options[low.selectedIndex].value>high.options[high.selectedIndex].value){
            alert("最低价不能高于最高价");
            return false
        }
    }
    return true;
}
