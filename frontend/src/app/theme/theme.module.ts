import {NgModule} from '@angular/core';
import {CommonModule} from '@angular/common';

import {ThemeRoutingModule} from './theme-routing.module';
import {ThemeListComponent} from './theme-list/theme-list.component';
import {ThemeListItemComponent} from './theme-list-item/theme-list-item.component';
import {ChartModule} from '../chart/chart.module';
import {MatCardModule} from '@angular/material';
import {ThemeService} from './theme.service';

@NgModule({
  declarations: [
    ThemeListComponent,
    ThemeListItemComponent
  ],
  imports: [
    CommonModule,
    ChartModule,
    MatCardModule,
    ThemeRoutingModule
  ],
  providers: [
    ThemeService
  ]
})
export class ThemeModule {
}
