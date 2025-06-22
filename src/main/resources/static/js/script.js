
/*共通の関数*/

/*並べ替え機能を付与しcallbackにはidの並びを配列にして渡す*/
function sortAdd(tbody, attrName, callback){
	Sortable.create(tbody,{
		animation: 150,
		onEnd: function(){
			const ids = [...tbody.children].map(row => row.dataset[attrName]);
			callback(ids);
		}
	})
}
