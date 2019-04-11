import {Component, OnInit} from '@angular/core';
import {ITheme, Theme} from '../themes.model';

@Component({
  selector: 'theme-list',
  templateUrl: './theme-list.component.html',
  styleUrls: ['./theme-list.component.scss']
})
export class ThemeListComponent implements OnInit {

  themes: Array<ITheme> = [
    new Theme(1, '테마1', '#111111'),
    new Theme(2, '테마2', '#222222'),
    new Theme(3, '테마3', '#333333'),
    new Theme(4, '테마4', '#444444'),
    new Theme(5, '테마5', '#555555'),
    new Theme(6, '테마6', '#666666'),
  ];

  constructor() {
  }

  ngOnInit() {
  }
}
