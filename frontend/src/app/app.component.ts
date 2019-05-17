import {Component, HostListener, OnInit} from '@angular/core';
import {Global} from './app.global.service';

class Menu {
  label: string;
  path: string;
  constructor(label: string, path: string) {
    this.label = label;
    this.path = path;
  }
}

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.scss']
})
export class AppComponent implements OnInit {

  menus: Menu[] = [
    new Menu('차트', '/theme'),
    new Menu('게시판', '/boards')
  ];

  constructor(
    private global: Global
  ) {

  }

  @HostListener('window:resize', ['$event'])
  onResize(e) {
    const columnCount = Math.floor(e.target.innerWidth / Global.CARD_WIDTH);
    if (columnCount !== this.global.columnCount) {
      this.global.columnCount = columnCount;
    }
  }

  ngOnInit(): void {

  }

  getToolbarWidth(): number {
    return Global.CARD_WIDTH * this.global.columnCount;
  }

  showSidebar(): boolean {
    return this.global.columnCount === 1;
  }
}
