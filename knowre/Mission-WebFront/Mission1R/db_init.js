var Sequelize = require('sequelize'),
	sequelize = new Sequelize('sqlite://localhost/:memory:');

var Problem = sequelize.define('problems', {
		problem_text: {
			type: Sequelize.STRING
		},
		type: {
			type: Sequelize.INTEGER
		},
		choices: {
			type: Sequelize.STRING
		},
		answer: {
			type: Sequelize.STRING
		}
	}, {
		paranoid: true
	});

var Result = sequelize.define('results', {
		problem_id: {
			type: Sequelize.INTEGER
		},
		answer: {
			type: Sequelize.STRING
		},
		result: {
			type: Sequelize.INTEGER
		}
	}, {
		paranoid: true
	});

Problem.sync({force: true}).then(function() {
	Problem.bulkCreate(data_to_insert);
});

Result.sync({force: true});

var data_to_insert = [
		{
			problem_text: '135 + 267 = ?',
			type: 1,
			choices: JSON.stringify([382, 392, 402, 412, 422]),
			answer: '3'
		},
		{
			problem_text: '다음 근사값에서 0이 유효숫자인지 확실하지 않은 것은?',
			type: 1,
			choices: JSON.stringify([0.05, 5.05, 5.50, 50, 505]),
			answer: '4'
		},
		{
			problem_text: '2개의 정수가 있다. 큰 수를 작은 수로 나누면 몫이 3이고 나머지가 3이다. 또, 작은 수에 35를 더한 수를 큰 수로 나누었더니 몫이 2이고 나머지가 4이었다. 큰 수를 구하면?',
			type: 1,
			choices: JSON.stringify([12, 14, 16, 18, 20]),
			answer: '4'
		},
		{
			problem_text: '거리가 9km인  A, B 두 지점 사이에 P점이 있다. A에서 P를 거쳐 B까지 가는 데 A에서 P까지는 시속 3km , P에서 B까지는 시속 4km 로 걸어서 2시간 30분이 걸렸다면 A에서 P까지의 거리는 몇 km?',
			type: 1,
			choices: JSON.stringify([3, 4, 5, 6, 7]),
			answer: '1'
		},
		{
			problem_text: '일차방정식 2x-3y+a=0의 한 해가 (-1, 3)일 때, a의 값은?',
			type: 1,
			choices: JSON.stringify([-11, 11, -7, 7, 5]),
			answer: '2'
		},
		{
			problem_text: '자연수 x, y 가 있다. 이 두 수의 합은 21이고, x의 2배를 3으로 나눈 값은 y에서 1을 뺀 값과 같다고 한다. 이 때, x의 값을 구하시오.',
			type: 1,
			choices: JSON.stringify([10, 11, 12, 13, 14]),
			answer: '3'
		},

		{
			problem_text: '상점에 물건을 사러 가는데 갈때는 분속 80m, 올 때는 분속 60m로 걸어서 50분 이내로 돌아오려면 집에서 상점까지의 거리가 몇 m 이내에 있어야 하는가? (단, 물건 사는데 8분 걸린다.)',
			type: 1,
			choices: JSON.stringify([274, 850, 1100, 1440, 1560]),
			answer: '4'
		},
		{
			problem_text: '철수는 3회의 수학 시험에서 각각 82점, 91점, 95점을 받았다. 다음 시험에서 몇 점 이상을 받아야 4회에 걸친 평균 성적이 90점 이상이 되겠는가?',
			type: 1,
			choices: JSON.stringify([91, 92, 93, 94, 95]),
			answer: '2'
		},
		{
			problem_text: '어떤 정수가 있다. 그 정수에서 2를 뺀 수는 그 정수의 1/2배와 1/3배의 합보다 작다고 한다. 이러한 정수 중에서 가장 큰 수는?',
			type: 1,
			choices: JSON.stringify([10, 11, 12, 13, 14]),
			answer: '2'
		},
		{
			problem_text: ' 3%의 소금물 400g 이 있다. 이것에서 몇 의 물을 증발시키면 5%의 소금물이 되겠는가?',
			type: 1,
			choices: JSON.stringify([130, 140, 150, 160, 170]),
			answer: '4'
		},
		{
			problem_text: '어떤 자동차가 9시에서 10시 사이에 경부고속도로 서울톨게이트를 출발하였다. 평균속도 88km/h인 이 자동차가 28km를 달리는 순간에 시계의 분침이 시침과 겹쳤다고 한다. 분침이 시침과 겹치는 시각을 분 단위로 반올림하여 구하여라.',
			type: 2,
			answer: '9시 49분'
		},
		{
			problem_text: '일차함수 y = ax+b 의 그래프에서 y의 값의 증가량이 x의 값의 증가량의 3배이고, x절편이 1일 때, a-b 의 값을 구하시오.',
			type: 2,
			answer: '6'
		},
		{
			problem_text: '직육면체의 물통에 수돗물을 채우고 있다. 오후 1시에 물이 이미 바닥에서 몇 cm높이로 차 있었다. 10분 후에 물의 높이가 바닥에서부터 25cm 가 되었고 25분 후에는 바닥에서부터 55cm 까지 찼다. 수돗물이 일정하게 나온다고 한다면 물의 높이가 75cm 가 되는 것은 몇 분 후인가?',
			type: 2,
			answer: '35분 후'
		}
	];

module.exports = {
	sequelize: sequelize,
	Problem: Problem,
	Result: Result
};