//console.log('Javascript loaded!');

var pData; // responseData
var cnt;  // problem count

$(document).ready(function() {
  $.ajax({
      url: "/api/fetchProblem",
      type: "get",
      success: function(data) {
          pData=data;
          //console.log(JSON.stringify(data));
          setProblem(data);
      }
  });

});
function submitBtnClick(){
  var input = new Array();
    for(let i=0;i<cnt;i++){
      if(pData.problems[i].type==1){
        input[i] = $('input[name="pb'+i+'"]:checked').val();
      }else{
        let temp=i+1;
        input[i] = $('#pb'+temp).val();
      }
      console.log((i+1)+"."+input[i]);
    }
}

function setProblem(data){
    cnt = Object.keys(data.problems).length;
    var choicesJson = JSON.parse(data.problems[0].choices);
    for(let i=0;i<cnt;i++){
      if(data.problems[i].type==1){
        $('#pzone').append($('<div/>', {
            id: 'problem'+i,
            text: data.problems[i].id +". "+data.problems[i].problem_text
        }));

        $('#problem'+i).append($('<div/>', {
            id: 'problem'+i
        }));
        choicesJson = JSON.parse(data.problems[i].choices);
        $('#problem'+i).append('<div style="float:right">');
        for(let j=0;j<5;j++){
          $('#problem'+i).append(
          '<input type="radio" name="pb'+i+'" value='+choicesJson[j]+'>'+choicesJson[j]
          );
        }
        $('#problem'+i).append('</div>');
      }else{
        $('#pzone').append($('<div/>', {
            id: 'problem'+i,
            text: data.problems[i].id +". "+data.problems[i].problem_text
        }));

        $('#problem'+i).append($('<div/>', {
            id: 'problem'+i
        }));
        choicesJson = JSON.parse(data.problems[i].choices);
        $('#problem'+i).append('<div><input type="text" id=pb'+data.problems[i].id+'></div>');


      }

    }
    // $('#foo').append($('<div/>', {
    //     id: 'myid',
    //     title: 'Hello world?',
    //     text: 'hello world'
    // }));
  // $('#foo').append($('<a/>', {
  //     href: 'https://www.google.co.kr',
  //     title: '나를 클릭하면 구글로 간다.',
  //     text: '클릭!'
  // }));
}
