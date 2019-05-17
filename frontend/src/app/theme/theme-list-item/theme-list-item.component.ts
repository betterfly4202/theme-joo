import {Component, Input, OnInit} from '@angular/core';
import {ITheme} from '../theme.model';
import {Global} from '../../app.global.service';

@Component({
  selector: 'theme-list-item',
  templateUrl: './theme-list-item.component.html',
  styleUrls: ['./theme-list-item.component.scss']
})
export class ThemeListItemComponent implements OnInit {

  @Input() theme: ITheme;
  width: number;
  padding: number = 24;
  margin: number = 16;

  height = {
    header: 65,
    chart: 300
  };

  constructor() {
    this.width = Global.CARD_WIDTH;
  }

  ngOnInit() {
  }
}
