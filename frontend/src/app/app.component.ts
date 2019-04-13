import {Component, OnInit} from '@angular/core';
import {Global} from './app.global.service';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.scss']
})
export class AppComponent implements OnInit {

  constructor(
    private global: Global
  ) {

  }

  ngOnInit(): void {

  }

  getToolbarWidth(): number {
    return Global.CARD_WIDTH * this.global.columnCount;
  }
}
