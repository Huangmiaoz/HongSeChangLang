var datas =[[
    '近代以来,中华民族面对着两大历史任务,一个是(  ),一个是实现国家繁荣富强和人民共同富裕',
    '实现民族复兴',
    '反对封建主义',
    '求得民族独立和人民解放',
    3
],[
    '全国抗战经过了战略防御、战略相持、战略反攻三年10月日本侵略军占领广州、(  )以后,抗日战争进战略相持阶段;1943年下半年以后,抗日战争逐渐转入局部反攻阶段。',
        '南京',
    '长沙',
    '武汉',
    3
],[
    '(  )中规定了“三三三”的政权组织原则',
        '《晋冀鲁豫边区政府纲领》',
    '《晋察冀边区目前施政纲领》',
    '《陕甘宁边区施政纲领》',
    3
],[
    '近代以来,中华民族面对着两大历史任务,一个是(  ),一个是实现国家繁荣富强和人民共同富裕',
    '实现民族复兴',
    '反对封建主义',
    '求得民族独立和人民解放',
    3
],[
    '全国抗战经过了战略防御、战略相持、战略反攻三年10月日本侵略军占领广州、(  )以后,抗日战争进战略相持阶段;1943年下半年以后,抗日战争逐渐转入局部反攻阶段。',
        '南京',
    '长沙',
    '武汉',
    3
],[
    '(  )中规定了“三三三”的政权组织原则',
        '《晋冀鲁豫边区政府纲领》',
    '《晋察冀边区目前施政纲领》',
    '《陕甘宁边区施政纲领》',
    3
]]
console.log(datas.length);
let index = 0,score = 0;
let ans = Array(10);
var startTime,endTime,res;
var btn = document.querySelector('button') ;
let sec = document.getElementById('sec');
let time = document.getElementById('time')

// 开始按钮
btn.onclick = function() {
    if(index == 0) {
        btn.innerHTML = '下一题';
        index++;

        // 计时
        time.style.display = "inline-block";
        startTime= +new Date();
        endTime = startTime + 30 * 1000;
        setInterval(resTime,1000);

        // 添加第一道题目
        add();
    } else {
        // 先清除已有的题目
        clear();
        index ++;
        add();
        if(index == 6 || res < 0) {
            btn.innerHTML = '答题结束';
            clear();
            score_sum();
            console.log(ans);
            btn.disabled=true;
        }
    }
}
// 更新页面题目
function add() {
    let ul = document.getElementById('work');
    for(let i = 0; i < datas[index - 1].length - 1; i++) {
        let li = document.createElement('li');   
        if(i == 0) {
            li.innerHTML = '题目'+ index + '   '+ datas[index - 1][i];
        } else {
            li.innerHTML ='<button id = "select">选我</button>'+"    " + datas[index - 1][i];
        }
        ul.appendChild(li);
    }
    var btn= document.querySelectorAll('#select');
    for(let i = 0;i < btn.length;i++) {
        btn[i].onclick = function () {
            for(let j=0;j<btn.length;j++) {
                btn[j].style.backgroundColor='';
            }
            btn[i].style.backgroundColor='#f16c4e';
            ans[index - 1] = i + 1;
        }
    }
}

// 清楚页面原有题目
function clear() {
    let ul = document.getElementById('work');
    while(ul.firstChild != undefined) {
        ul.removeChild(ul.firstChild);
    }
}

// 计时器
function resTime() {
    let thisTime = new Date();
    res = endTime - thisTime;
    if(res >= 0)
        sec.innerHTML = '还剩下：' + parseInt(res / 1000) + '秒';
    else sec.innerHTML = '时间到';
    
}

// 统计总分
function score_sum() {
    for(let i = 0; i < datas.length; i++) {
        if(datas[i][datas[i].length-1] == ans[i]) {
            score += 10;
        }
    }
    let ul = document.getElementById('work');
    let word = '您的得分为' + score;
    ul.innerHTML = '<h1 class = "score">'+ word +'</h1>';
}
