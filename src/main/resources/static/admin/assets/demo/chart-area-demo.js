// Set new default font family and font color to mimic Bootstrap's default styling
Chart.defaults.global.defaultFontFamily = '-apple-system,system-ui,BlinkMacSystemFont,"Segoe UI",Roboto,"Helvetica Neue",Arial,sans-serif';
Chart.defaults.global.defaultFontColor = '#292b2c';

// Area Chart Example

function resetAreaCanvas(){
	document.querySelector('#myAreaChart').remove();
	
	const canvas = document.createElement("canvas");
	
	canvas.setAttribute("id", "myAreaChart");
	document.getElementById("AreaChartContainer").appendChild(canvas);
	
	//document.getElementById("AreaChartContainer").insertAdjacentHTML('afterbegin', "<canvas id='myAreaChart' width='100%' height='40'></canvas>");
	ctx = document.querySelector("#myAreaChart");
};


	async function getAreaChartData() {
		
		let response = await fetch("http://localhost:8080/getAreaChartData", {
			method: "Post",
		});
		
		let parseResponse = await response.json();
		//console.log(parseResponse);
		
			if(parseResponse.code == 1) { // ajax는 자바스크립트에서 분기 시켜줘야 한다
				
				resetAreaCanvas();
				
				var areaChart = new Chart(ctx, {
				  type: 'line',
				  data: {
					labels: [],
				    datasets: [{
				      label: "일별 방문자수",
				      lineTension: 0.3,
				      backgroundColor: "rgba(2,117,216,0.2)",
				      borderColor: "rgba(2,117,216,1)",
				      pointRadius: 5,
				      pointBackgroundColor: "rgba(2,117,216,1)",
				      pointBorderColor: "rgba(255,255,255,0.8)",
				      pointHoverRadius: 5,
				      pointHoverBackgroundColor: "rgba(2,117,216,1)",
				      pointHitRadius: 50,
				      pointBorderWidth: 2,	
				      data: [],
				    }],
				  },
				  options: {
				    scales: {
				      xAxes: [{
				        time: {
				          unit: 'date'
				        },
				        gridLines: {
				          display: false
				        },
				        ticks: {
				          maxTicksLimit: 7
				        }
				      }],
				      yAxes: [{
				        ticks: {
				          min: 0,
				          maxTicksLimit: 5
				        },
				        gridLines: {
				          color: "rgba(0, 0, 0, .125)",
				        }
				      }],
				    },
				    legend: {
				      display: false
				    }
				  }
				});
				
				var areaLabelList = areaChart["data"]["labels"];
				var areaValueList = areaChart["data"]["datasets"]["0"]["data"];
				
				// 일별 방문자 수 차트
				var tJsonData = parseResponse.body;
				var tJData = JSON.parse(tJsonData);

				
					for (var i = 0; i < tJData.length; i++) { // tJData의 길이 까지 차트에 데이터를 집어넣는다
						var t = tJData[i];
						areaLabelList.push(t.Time);
						areaValueList.push(t.Count);
					}
	
				areaChart.update();

			} else {
				console.log("차트를 불러올 수 없습니다.")
			}

	}
