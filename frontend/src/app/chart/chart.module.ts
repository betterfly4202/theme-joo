import {NgModule} from '@angular/core';
import {CommonModule} from '@angular/common';

import {LineChartComponent} from './line-chart/line-chart.component';
import {ChartsModule} from 'ng2-charts';

@NgModule({
  declarations: [
    LineChartComponent
  ],
  exports: [
    LineChartComponent
  ],
  imports: [
    CommonModule,
    ChartsModule
  ]
})
export class ChartModule {
}
