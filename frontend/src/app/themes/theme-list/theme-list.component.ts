import {Component, OnInit} from '@angular/core';
import {ITheme, Theme} from '../themes.model';
import {BreakpointObserver, BreakpointState} from '@angular/cdk/layout';

enum Breakpoint {
  MOBILE = '(max-width:600px)',
  WEB = '(min-width:1200px)'
}

@Component({
  selector: 'theme-list',
  templateUrl: './theme-list.component.html',
  styleUrls: ['./theme-list.component.scss']
})
export class ThemeListComponent implements OnInit {

  private CARD_WIDTH = 300;

  themes: Array<ITheme> = [
    new Theme(1, '테마1', '테마1 부제목', '#111111'),
    new Theme(2, '테마2', '테마2 부제목', '#222222'),
    new Theme(3, '테마3', '테마3 부제목', '#333333'),
    new Theme(4, '테마4', '테마4 부제목', '#444444'),
    new Theme(5, '테마5', '테마5 부제목', '#555555'),
    new Theme(6, '테마6', '테마6 부제목', '#666666'),
  ];
  cols: number;

  constructor(
    private breakpointObserver: BreakpointObserver
  ) {
    this.breakpointObserver
      .observe([Breakpoint.MOBILE, Breakpoint.WEB])
      .subscribe((state: BreakpointState) => {
        if (state.breakpoints[Breakpoint.MOBILE]) {
          this.cols = 2;
        } else if (state.breakpoints[Breakpoint.WEB]) {
          this.cols = 4;
        } else {
          this.cols = 3;
        }
      });
  }

  ngOnInit() {
  }

  getWidth(): number {
    return this.cols * this.CARD_WIDTH;
  }
}
