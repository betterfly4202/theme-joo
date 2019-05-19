import {Component, Input, OnInit} from '@angular/core';
import {ChartDataSets, ChartOptions} from 'chart.js';
import {Label} from 'ng2-charts';
import _ from 'partial-js';

@Component({
  selector: 'line-chart',
  templateUrl: './line-chart.component.html',
  styleUrls: ['./line-chart.component.scss']
})
export class LineChartComponent implements OnInit {

  @Input() chartData: number[];
  @Input() width: number;
  @Input() height: number;

  lineChartOptions: ChartOptions = {
    responsive: false
  };

  loading: boolean = true;

  constructor() {

  }

  ngOnInit() {
    this.loading = false;
  }

  getData(): ChartDataSets[] {
    return [
      {
        data : this.chartData
      }
    ];
  }

  getLabels(): Label[] {
    return _.go(
      _.range(50),
      _.map(v => v)
    );
  }
}
