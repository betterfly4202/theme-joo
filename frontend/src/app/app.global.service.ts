import {Injectable} from '@angular/core';

export enum Screen { /* count */
  MOBILE = 2, TABLET = 3, WEB = 4
}

@Injectable()
export class Global {
  CARD_WIDTH: number;
  screen: Screen;

  constructor() {
    this.CARD_WIDTH = 300;
  }
}
