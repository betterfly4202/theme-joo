import {NgModule} from '@angular/core';
import {CommonModule} from '@angular/common';

import {ThemesRoutingModule} from './themes-routing.module';
import {ThemeListComponent} from './theme-list/theme-list.component';

@NgModule({
  declarations: [ThemeListComponent],
  imports: [
    CommonModule,
    ThemesRoutingModule
  ]
})
export class ThemesModule {
}
