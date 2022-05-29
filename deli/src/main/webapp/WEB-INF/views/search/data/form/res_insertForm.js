
//resname,reslat,reslon,mylat,mylon,resdist,category,cate_no

let cate_arr = new Array();
cate_arr = ['돈까스·회·일식','중식','치킨','백반·죽·국수','카페·디저트','분식',
'찜·탕·찌개','피자','양식','고기·구이','족발·보쌈','아시안','페스트푸드','도시락'];


function changeSelect(){
	let selectBox = document.getElementById("selectBox");
	let category = document.getElementById("category");
	category.value = cate_arr[selectBox.value-1];
	let cate_no = document.getElementById("cate_no");
	cate_no.value = 100+selectBox.value;
}
