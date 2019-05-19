import {Component, OnInit} from '@angular/core';
import {Global} from '../../app.global.service';
import {ThemeService} from '../theme.service';
import {ITheme} from '../theme.model';

@Component({
  selector: 'theme-list',
  templateUrl: './theme-list.component.html',
  styleUrls: ['./theme-list.component.scss']
})
export class ThemeListComponent implements OnInit {

  themes: ITheme[];

  constructor(
    private global: Global,
    private themeService: ThemeService
  ) {
  }

  ngOnInit() {
    this.themeService.getThemes().subscribe(themes => this.themes = themes);
  }

  getContainerWidth(): number {
    return this.global.columnCount * Global.CARD_WIDTH;
  }
}
