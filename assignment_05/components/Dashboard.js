import React from 'react';
import axios from 'axios';
import { Chart } from "react-google-charts";

import Container from 'react-bootstrap/Container';
import Row from "react-bootstrap/Row";
import Col from  "react-bootstrap/Col";
 
 
export default class Dashboard extends React.Component {
    state = {
        chart_data: []
    }

    componentDidMount() {
        this.getData();
    }

    getData() {
        axios.get('http://localhost:8080/api/dashboard')
        .then(response => {
            let chart_data = response.data;
            console.log(chart_data);
            this.setState({ chart_data });
        })
        .catch(error => {
            console.error("Error fetching data:", error);
        });
    }

    render() {
        const temperatures = this.state.chart_data.temperatures;
        const population = this.state.chart_data.population;

        var temps = [];
        if (temperatures) {
            for (var i = 0; i < temperatures.length; i++) {
                if (i !== 0) {
                    temps.push( {"month": temperatures[i][0], "high": temperatures[i][1], "low": temperatures[i][2]} )
                }
            }
        }

        const options = {
            title: "Population of Nova Scotia",
            hAxis: {
                title: "Total Population",
                minValue: 0
            },
            yAxis: { 
                title: "Year",
                format: "####"
            },
        };

        return (
            <div className='container'>
                <br/>
                <h3>Charts</h3>
                <br/>

                <div>
                    <h3>Average Temperatures</h3>
                    <Chart
                        chartType="LineChart"
                        width="500px"
                        height="500px"
                        data={temperatures}
                    />

                    <h3>Population</h3>
                    <Chart
                        chartType="BarChart"
                        width="500px"
                        height="500px"
                        data={population}
                        options={options}
                    />
                </div>

                <h3>Temperatures Grid</h3>

                <Container>
                <Row>
                    <Col>Month</Col>
                    <Col>Hight</Col>
                    <Col>Low</Col>
                </Row>
                {
                    temps?.map(temp =>
                        <Row  key={temp.month}>
                        <Col>{ temp.month }</Col>
                        <Col>{ temp.high }</Col>
                        <Col>{ temp.low }</Col>
                        </Row>
                    )
                }
                </Container>

            </div>

        );
    }
}