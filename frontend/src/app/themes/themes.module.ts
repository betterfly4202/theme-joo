import {NgModule} from '@angular/core';
import {CommonModule} from '@angular/common';

import {ThemesRoutingModule} from './themes-routing.module';
import {ThemeListComponent} from './theme-list/theme-list.component';
import {ThemeListItemComponent} from './theme-list-item/theme-list-item.component';
import {ChartModule} from '../chart/chart.module';
import {MatGridListModule} from '@angular/material';

@NgModule({
  declarations: [
    ThemeListComponent,
    ThemeListItemComponent
  ],
  imports: [
    CommonModule,
    ChartModule,
    MatGridListModule,
    ThemesRoutingModule
  ]
})
export class ThemesModule {
}
