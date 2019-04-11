import {Component, OnInit} from '@angular/core';
import {BreakpointObserver, BreakpointState} from '@angular/cdk/layout';
import {Global, Screen} from './app.global.service';

enum Breakpoint {
  MOBILE = '(max-width:600px)',
  WEB = '(min-width:1200px)'
}

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.scss']
})
export class AppComponent implements OnInit {

  constructor(
    private breakpointObserver: BreakpointObserver,
    private global: Global
  ) {
    this.breakpointObserver
      .observe([Breakpoint.MOBILE, Breakpoint.WEB])
      .subscribe((state: BreakpointState) => {
        if (state.breakpoints[Breakpoint.MOBILE]) {
          this.global.screen = Screen.MOBILE;
        } else if (state.breakpoints[Breakpoint.WEB]) {
          this.global.screen = Screen.WEB;
        } else {
          this.global.screen = Screen.TABLET;
        }
        console.log(this.global.screen);
      });
  }
  ngOnInit(): void {
  }
  getToolbarWidth(): number {
    return this.global.CARD_WIDTH * this.global.screen;
  }
}
