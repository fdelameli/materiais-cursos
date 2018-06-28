VERSION 5.00
Object = "{648A5603-2C6E-101B-82B6-000000000014}#1.1#0"; "MSCOMM32.OCX"
Begin VB.Form Form1 
   BackColor       =   &H00FFFFFF&
   Caption         =   "Programa de Amostragem de Conversão A/D"
   ClientHeight    =   5700
   ClientLeft      =   2565
   ClientTop       =   2160
   ClientWidth     =   9405
   LinkTopic       =   "Form1"
   MaxButton       =   0   'False
   MinButton       =   0   'False
   ScaleHeight     =   5700
   ScaleWidth      =   9405
   Begin VB.PictureBox Picture1 
      BorderStyle     =   0  'None
      Height          =   1095
      Left            =   3120
      Picture         =   "frmmain.frx":0000
      ScaleHeight     =   1095
      ScaleWidth      =   3015
      TabIndex        =   9
      Top             =   4200
      Width           =   3015
   End
   Begin VB.Timer Timer1 
      Interval        =   1
      Left            =   0
      Top             =   0
   End
   Begin MSCommLib.MSComm com 
      Left            =   480
      Top             =   -120
      _ExtentX        =   1005
      _ExtentY        =   1005
      _Version        =   393216
      DTREnable       =   -1  'True
   End
   Begin VB.Line Line3 
      Index           =   0
      Visible         =   0   'False
      X1              =   6360
      X2              =   6360
      Y1              =   4320
      Y2              =   5520
   End
   Begin VB.Label Label8 
      BackStyle       =   0  'Transparent
      Caption         =   "Osciloscópio - www.cerne-tec.com.br"
      BeginProperty Font 
         Name            =   "MS Sans Serif"
         Size            =   8.25
         Charset         =   0
         Weight          =   700
         Underline       =   0   'False
         Italic          =   0   'False
         Strikethrough   =   0   'False
      EndProperty
      ForeColor       =   &H8000000D&
      Height          =   255
      Left            =   3120
      TabIndex        =   8
      Top             =   3960
      Width           =   3615
   End
   Begin VB.Line Line8 
      X1              =   600
      X2              =   720
      Y1              =   2040
      Y2              =   2040
   End
   Begin VB.Line Line7 
      X1              =   600
      X2              =   720
      Y1              =   2280
      Y2              =   2280
   End
   Begin VB.Line Line6 
      X1              =   600
      X2              =   720
      Y1              =   2520
      Y2              =   2520
   End
   Begin VB.Line Line5 
      Index           =   0
      X1              =   600
      X2              =   720
      Y1              =   2760
      Y2              =   2760
   End
   Begin VB.Label Label7 
      BackStyle       =   0  'Transparent
      Caption         =   "t(s)"
      BeginProperty Font 
         Name            =   "MS Sans Serif"
         Size            =   8.25
         Charset         =   0
         Weight          =   700
         Underline       =   0   'False
         Italic          =   0   'False
         Strikethrough   =   0   'False
      EndProperty
      Height          =   255
      Left            =   8880
      TabIndex        =   7
      Top             =   3120
      Width           =   255
   End
   Begin VB.Label Label1 
      BackStyle       =   0  'Transparent
      Caption         =   "A(V)"
      BeginProperty Font 
         Name            =   "MS Sans Serif"
         Size            =   8.25
         Charset         =   0
         Weight          =   700
         Underline       =   0   'False
         Italic          =   0   'False
         Strikethrough   =   0   'False
      EndProperty
      Height          =   255
      Left            =   240
      TabIndex        =   6
      Top             =   960
      Width           =   375
   End
   Begin VB.Label lblR 
      BackStyle       =   0  'Transparent
      Height          =   255
      Left            =   2160
      TabIndex        =   5
      Top             =   3240
      Visible         =   0   'False
      Width           =   855
   End
   Begin VB.Image Image1 
      BorderStyle     =   1  'Fixed Single
      Height          =   3015
      Left            =   0
      Top             =   840
      Width           =   9375
   End
   Begin VB.Label Label6 
      BackStyle       =   0  'Transparent
      Caption         =   "0"
      Height          =   255
      Left            =   240
      TabIndex        =   4
      Top             =   3120
      Width           =   135
   End
   Begin VB.Label Label5 
      BackStyle       =   0  'Transparent
      Caption         =   "1,25"
      BeginProperty Font 
         Name            =   "MS Sans Serif"
         Size            =   8.25
         Charset         =   0
         Weight          =   700
         Underline       =   0   'False
         Italic          =   0   'False
         Strikethrough   =   0   'False
      EndProperty
      Height          =   255
      Left            =   240
      TabIndex        =   3
      Top             =   2640
      Width           =   375
   End
   Begin VB.Label Label4 
      BackStyle       =   0  'Transparent
      Caption         =   "2,50"
      BeginProperty Font 
         Name            =   "MS Sans Serif"
         Size            =   8.25
         Charset         =   0
         Weight          =   700
         Underline       =   0   'False
         Italic          =   0   'False
         Strikethrough   =   0   'False
      EndProperty
      Height          =   255
      Left            =   240
      TabIndex        =   2
      Top             =   2400
      Width           =   375
   End
   Begin VB.Label Label3 
      BackStyle       =   0  'Transparent
      Caption         =   "3,75"
      BeginProperty Font 
         Name            =   "MS Sans Serif"
         Size            =   8.25
         Charset         =   0
         Weight          =   700
         Underline       =   0   'False
         Italic          =   0   'False
         Strikethrough   =   0   'False
      EndProperty
      Height          =   255
      Left            =   240
      TabIndex        =   1
      Top             =   2160
      Width           =   375
   End
   Begin VB.Label Label2 
      BackStyle       =   0  'Transparent
      Caption         =   "5,00"
      BeginProperty Font 
         Name            =   "MS Sans Serif"
         Size            =   8.25
         Charset         =   0
         Weight          =   700
         Underline       =   0   'False
         Italic          =   0   'False
         Strikethrough   =   0   'False
      EndProperty
      Height          =   255
      Left            =   240
      TabIndex        =   0
      Top             =   1920
      Width           =   375
   End
   Begin VB.Line linr 
      X1              =   720
      X2              =   720
      Y1              =   3000
      Y2              =   2880
   End
   Begin VB.Line Line2 
      BorderWidth     =   3
      X1              =   120
      X2              =   9000
      Y1              =   3000
      Y2              =   3000
   End
   Begin VB.Line Line1 
      BorderWidth     =   3
      X1              =   720
      X2              =   720
      Y1              =   1080
      Y2              =   3480
   End
End
Attribute VB_Name = "Form1"
Attribute VB_GlobalNameSpace = False
Attribute VB_Creatable = False
Attribute VB_PredeclaredId = True
Attribute VB_Exposed = False
Dim i As Integer
Private Sub Command1_Click()
com.Output = "A"


End Sub

Private Sub Form_Load()
On Error GoTo trata_error
com.CommPort = 1
com.DTREnable = True
com.RTSEnable = True


com.PortOpen = True
i = o
Exit Sub
trata_error:
    MsgBox "Ocorreu um erro ao abrir esta porta."
    MsgBox "Numero: " & Str(Err.Number) & " - Descrição: " & Err.Description
    

    


End Sub

Private Sub Image1_Click()

End Sub

Private Sub Timer1_Timer()
    i = i + 1
    linr.X1 = linr.X1 + 1
    linr.X2 = linr.X2 + 1
    Load Line3(i)
    Line3(i).X2 = linr.X2
    Line3(i).X1 = linr.X1
    Line3(i).Y1 = linr.Y1
    Line3(i).Y2 = 3000 'linr.Y2
    Line3(i).Visible = True
    h = com.Input
If Len(h) > 1 Then
    'lblR.Caption = Mid(com.Input, 1, 1)
    linr.Y1 = 3000 - Asc(Mid(h, 1, 1)) * 4
End If
If Len(h) = 1 Then
  '  lblR.Caption = com.Input
    linr.Y1 = 3000 - Asc(h) * 4
End If

End Sub
