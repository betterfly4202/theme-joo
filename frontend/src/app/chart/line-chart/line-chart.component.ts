import {Component, Input, OnInit} from '@angular/core';
import {ChartEvent, ChartType} from 'ng-chartist';
import {IChartistAnimationOptions, IChartistData, ILineChartOptions} from 'chartist';

@Component({
  selector: 'line-chart',
  templateUrl: './line-chart.component.html',
  styleUrls: ['./line-chart.component.scss']
})
export class LineChartComponent implements OnInit {

  @Input() chartData: number[];

  loading: boolean = true;

  type: ChartType = 'Line';
  data: IChartistData;
  options: ILineChartOptions = {
    axisX: {
      showGrid: false,
      showLabel: false
    },
    axisY: {
      showGrid: false,
      showLabel: false
    },
    showPoint: false,
    showArea: false,
    fullWidth: true,
    height: 300
  };

  events: ChartEvent = {
    draw: (data) => {
      data.element.animate({
        y2: {
          dur: '1s',
          from: data.y1,
          to: data.y2,
          easing: 'easeOutQuad'
        } as IChartistAnimationOptions
      });
    }
  };

  constructor() {

  }

  ngOnInit() {
    this.data = {
      series: [this.chartData]
    };
    this.loading = false;
  }

}
