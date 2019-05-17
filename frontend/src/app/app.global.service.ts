import {Injectable} from '@angular/core';
import {BreakpointObserver, BreakpointState} from '@angular/cdk/layout';


export class ColumnBreakpoint {
  one: string;
  two: string;
  three: string;

  constructor(width: number) {
    this.one = `(max-width:${width * 2}px)`;
    this.two = `(max-width:${width * 3}px)`;
    this.three = `(max-width:${width * 4}px)`;
  }

  getColumnCount(state: BreakpointState): number {
    if (state.breakpoints[this.one]) {
      return 1;
    } else if (state.breakpoints[this.two]) {
      return 2;
    } else if (state.breakpoints[this.three]) {
      return 3;
    } else {
      return 4;
    }
  }
}

@Injectable()
export class Global {

  public static CARD_WIDTH = 375;

  columnBreakpoint: ColumnBreakpoint;
  columnCount: number;

  constructor(
    private breakpointObserver: BreakpointObserver
  ) {
    this.columnBreakpoint = new ColumnBreakpoint(Global.CARD_WIDTH);

    breakpointObserver
      .observe([this.columnBreakpoint.one, this.columnBreakpoint.two, this.columnBreakpoint.three])
      .subscribe((state: BreakpointState) => this.columnCount = this.columnBreakpoint.getColumnCount(state));
  }
}
