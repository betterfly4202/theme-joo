import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';

import {ChartistModule} from 'ng-chartist';
import {LineChartComponent} from './line-chart/line-chart.component';

@NgModule({
  declarations: [
    LineChartComponent
  ],
  exports: [
    LineChartComponent
  ],
  imports: [
    CommonModule,
    ChartistModule
  ]
})
export class ChartModule { }
