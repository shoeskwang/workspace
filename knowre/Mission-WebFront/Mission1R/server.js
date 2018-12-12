var fs = require('fs'),
	express = require('express'),
	bodyParser = require('body-parser'),
	db = require('./db_init.js'),
	app = express();

app.use(express.static('static'));
app.use(bodyParser.urlencoded({ extended: true }));

app.get('/api/fetchProblem', function(req, res) {
	db.Problem.findAll({}).then(function(problems) {
		res.json(
			{
				problems: problems.map(function(p) {
					return {
						id: p.id,
						problem_text: p.problem_text,
						type: p.type,
						choices: p.choices
					};
				})
			}
		);
	})

});

app.post('/api/submit', function(req, res) {
	var input = JSON.parse(req.body.input),
		results;

	db.Problem.findAll({}).then(function(problems) {
		results = problems.map(function(p, idx) {
			return {
				id: p.id,
				result: (input[idx].answer === p.answer),
				answer: p.answer
			};
		});

		db.Result.bulkCreate(results.map(function(r) {
			return {
				problem_id: r.id,
				result: r.result ? 1 : 0,
				answer: r.answer
			};
		})).then(function() {
			res.json({
				results: results
			});
		});
	});
});

var server = app.listen(3000, function() {
		console.log('Server started');
	});
